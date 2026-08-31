package com.piprapay.companion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.piprapay.companion.navigation.AppNavigation
import com.piprapay.companion.navigation.BottomNavItem
import com.piprapay.companion.navigation.Screen
import com.piprapay.companion.ui.analytics.AnalyticsScreen
import com.piprapay.companion.ui.home.HomeScreen
import com.piprapay.companion.ui.login.LoginScreen
import com.piprapay.companion.ui.permission.PermissionScreen
import com.piprapay.companion.ui.senders.SendersScreen
import com.piprapay.companion.ui.settings.SettingsScreen
import com.piprapay.companion.ui.theme.PiprapayTheme
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.ToggleOff
import com.piprapay.companion.ui.theme.White
import com.piprapay.companion.ui.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PiprapayTheme {
                AppNavigation()
            }
        }
    }
}
