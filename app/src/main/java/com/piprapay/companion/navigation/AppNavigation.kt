package com.piprapay.companion.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.piprapay.companion.ui.analytics.AnalyticsScreen
import com.piprapay.companion.ui.home.HomeScreen
import com.piprapay.companion.ui.login.LoginScreen
import com.piprapay.companion.ui.permission.PermissionScreen
import com.piprapay.companion.ui.senders.SendersScreen
import com.piprapay.companion.ui.settings.SettingsScreen
import com.piprapay.companion.ui.theme.CardBackground
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.ToggleOff
import com.piprapay.companion.ui.theme.White
import com.piprapay.companion.ui.welcome.WelcomeScreen

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Permission : Screen("permission")
    object Login : Screen("login")
    object Home : Screen("home")
    object Senders : Screen("senders")
    object Analytics : Screen("analytics")
    object Settings : Screen("settings")
}

data class BottomNavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Home, "Home", Icons.Default.Home),
    BottomNavItem(Screen.Senders, "Senders", Icons.Default.Send),
    BottomNavItem(Screen.Analytics, "Analytic", Icons.Default.BarChart),
    BottomNavItem(Screen.Settings, "Setting", Icons.Default.Settings)
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomBar = currentDestination?.hierarchy?.any { dest ->
        bottomNavItems.any { it.screen.route == dest.route }
    } == true

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = CardBackground
                ) {
                    bottomNavItems.forEach { item ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.route == item.screen.route
                        } == true

                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label,
                                    tint = if (selected) Primary else TextSecondary
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (selected) Primary else TextSecondary
                                )
                            },
                            selected = selected,
                            onClick = {
                                navController.navigate(item.screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = ToggleOff
                            )
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Welcome.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            composable(Screen.Welcome.route) {
                WelcomeScreen(
                    onContinue = {
                        navController.navigate(Screen.Permission.route) {
                            popUpTo(Screen.Welcome.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Permission.route) {
                PermissionScreen(
                    onContinue = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.Permission.route) { inclusive = true }
                        }
                    },
                    onSkip = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Welcome.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Login.route) {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Welcome.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen()
            }

            composable(Screen.Senders.route) {
                SendersScreen()
            }

            composable(Screen.Analytics.route) {
                AnalyticsScreen()
            }

            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}
