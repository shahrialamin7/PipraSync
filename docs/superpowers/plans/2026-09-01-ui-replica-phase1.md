# PipraPay Companion UI Replica - Phase 1 Implementation Plan

> **For agentic workers:** Use subagent-driven-development or executing-plans to implement this plan task-by-task.

**Goal:** Build an exact pixel-perfect replica of the PipraPay Companion app UI using Kotlin + Jetpack Compose.

**Architecture:** Single-activity Compose app with navigation, 4-tab bottom nav, Material3 theming.

**Tech Stack:** Kotlin 2.2, Jetpack Compose, Material3, Poppins font, GitHub Actions for builds.

**Design System:**
- Primary: `#6C5CE7`
- Background: `#FFFFFF`
- Card: `#F8F9FA`
- Text Primary: `#1A1A2E`
- Text Secondary: `#6B7280`
- Success: `#22C55E`
- Font: Poppins (Regular, Medium, Semibold, Bold)

---

## File Structure

```
app/src/main/java/com/piprapay/companion/
├── PiprapayApp.kt                 (Application class)
├── MainActivity.kt                (Single activity)
├── navigation/
│   └── AppNavigation.kt           (Nav host + bottom nav)
├── ui/
│   ├── theme/
│   │   ├── Color.kt               (Color definitions)
│   │   ├── Type.kt                (Poppins typography)
│   │   └── Theme.kt               (Material3 theme)
│   ├── components/
│   │   ├── SyncButton.kt          (Purple pill button)
│   │   ├── TabSelector.kt         (Pending/Stored/Used/Error tabs)
│   │   ├── SmsCard.kt             (SMS item card)
│   │   ├── SenderCard.kt          (Sender list item)
│   │   ├── StatusBadge.kt         (STORED/USED/ERROR badges)
│   │   ├── MessageDetailSheet.kt  (Bottom sheet)
│   │   └── EmptyState.kt          (Empty inbox state)
│   ├── welcome/
│   │   └── WelcomeScreen.kt
│   ├── permission/
│   │   └── PermissionScreen.kt
│   ├── login/
│   │   └── LoginScreen.kt
│   ├── home/
│   │   └── HomeScreen.kt
│   ├── senders/
│   │   └── SendersScreen.kt
│   ├── analytics/
│   │   └── AnalyticsScreen.kt
│   └── settings/
│       └── SettingsScreen.kt
└── res/
    └── font/
        ├── poppins_regular.ttf
        ├── poppins_medium.ttf
        ├── poppins_semibold.ttf
        └── poppins_bold.ttf
```

---

## Global Constraints

- Kotlin 2.2.0, Gradle 8.13, AGP 8.13.2
- minSdk 24, targetSdk 35, compileSdk 35
- Material3 only, no Material2
- Poppins font family
- No backend logic in Phase 1
- No Firebase in Phase 1
- Exact pixel replica of original app

---

## Task 1: Project Setup

**Files:**
- Create: `build.gradle.kts` (root)
- Create: `app/build.gradle.kts`
- Create: `settings.gradle.kts`
- Create: `gradle.properties`
- Create: `app/src/main/AndroidManifest.xml`
- Create: `app/src/main/java/com/piprapay/companion/PiprapayApp.kt`
- Create: `app/src/main/java/com/piprapay/companion/MainActivity.kt`

**Steps:**

- [ ] Create root `build.gradle.kts` with Kotlin 2.2.0, AGP 8.13.2
- [ ] Create `app/build.gradle.kts` with Compose, Material3, minSdk 24
- [ ] Create `settings.gradle.kts` with repository config
- [ ] Create `gradle.properties` with AndroidX + Compose flags
- [ ] Create `AndroidManifest.xml` with internet permission
- [ ] Create `PiprapayApp.kt` (Application class)
- [ ] Create `MainActivity.kt` (setContent with theme)
- [ ] Verify: `./gradlew assembleDebug` builds successfully

---

## Task 2: Design System - Colors

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/theme/Color.kt`

**Steps:**

- [ ] Create Color.kt with all colors from original app

```kotlin
package com.piprapay.companion.ui.theme

import androidx.compose.ui.graphics.Color

// Primary
val Primary = Color(0xFF6C5CE7)
val PrimaryLight = Color(0xFF8B7CF7)
val PrimaryDark = Color(0xFF5A4BD6)

// Background
val Background = Color(0xFFFFFFFF)
val CardBackground = Color(0xFFF8F9FA)
val SurfaceVariant = Color(0xFFF3F4F6)

// Text
val TextPrimary = Color(0xFF1A1A2E)
val TextSecondary = Color(0xFF6B7280)
val TextHint = Color(0xFF9CA3AF)

// Status
val Success = Color(0xFF22C55E)
val SuccessBg = Color(0xFFDCFCE7)
val Error = Color(0xFFEF4444)
val ErrorBg = Color(0xFFFEE2E2)
val Warning = Color(0xFFF59E0B)

// Toggle
val ToggleOn = Color(0xFF6C5CE7)
val ToggleOff = Color(0xFFD1D5DB)

// Divider
val Divider = Color(0xFFE5E7EB)

// Bottom Nav
val NavInactive = Color(0xFF9CA3AF)
```

- [ ] Verify: File compiles without errors

---

## Task 3: Design System - Typography

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/theme/Type.kt`
- Create: `app/src/main/res/font/` directory
- Download: Poppins font files (4 weights)

**Steps:**

- [ ] Download Poppins fonts (Regular 400, Medium 500, SemiBold 600, Bold 700)
- [ ] Place in `app/src/main/res/font/`
- [ ] Create Type.kt with Poppins font family

```kotlin
package com.piprapay.companion.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp
    )
)
```

- [ ] Verify: File compiles without errors

---

## Task 4: Design System - Theme

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/theme/Theme.kt`

**Steps:**

- [ ] Create Theme.kt with Material3 theme using colors + typography

```kotlin
package com.piprapay.companion.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Background,
    primaryContainer = PrimaryLight,
    secondary = Primary,
    background = Background,
    surface = Background,
    surfaceVariant = CardBackground,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary,
    error = Error,
    outline = Divider
)

@Composable
fun PiprapayTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
```

- [ ] Verify: File compiles without errors

---

## Task 5: Navigation Setup

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/navigation/AppNavigation.kt`

**Steps:**

- [ ] Create sealed class for screens
- [ ] Create bottom nav bar component
- [ ] Create NavHost with all routes

```kotlin
package com.piprapay.companion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

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
```

- [ ] Verify: File compiles without errors

---

## Task 6: Welcome Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/welcome/WelcomeScreen.kt`

**Steps:**

- [ ] Create WelcomeScreen composable matching original UI
- [ ] Logo centered, title, privacy text, continue button
- [ ] Navigate to Permission on click

- [ ] Verify: Screen displays correctly on emulator/device

---

## Task 7: Permission Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/permission/PermissionScreen.kt`

**Steps:**

- [ ] Create PermissionScreen with explanation text
- [ ] Two checkboxes: SMS (required), Notification (optional)
- [ ] "Give Permissions" button
- [ ] Request SMS + Notification permissions
- [ ] Navigate to Login on completion

- [ ] Verify: Permissions requested correctly

---

## Task 8: Login Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/login/LoginScreen.kt`

**Steps:**

- [ ] Create LoginScreen with logo, URL field, password field
- [ ] Password show/hide toggle (eye icon)
- [ ] Sign in button with loading state
- [ ] QR code button placeholder
- [ ] Navigate to Home on success

- [ ] Verify: UI matches original screenshot

---

## Task 9: Home Screen - Core

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/home/HomeScreen.kt`

**Steps:**

- [ ] Create HomeScreen with top bar (logo, greeting, sync button)
- [ ] Add tab selector (Pending, Stored, Used, Error)
- [ ] Add empty state component
- [ ] Add SMS card list (placeholder data)
- [ ] Add bottom sheet for message details

- [ ] Verify: UI matches original screenshots

---

## Task 10: Home Screen - Components

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/components/SyncButton.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/TabSelector.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/SmsCard.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/StatusBadge.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/EmptyState.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/MessageDetailSheet.kt`

**Steps:**

- [ ] Create SyncButton (purple pill, refresh icon)
- [ ] Create TabSelector (4 tabs, rounded, selected state)
- [ ] Create SmsCard (sender, SIM badge, date, message, status)
- [ ] Create StatusBadge (STORED=green, USED=blue, ERROR=red)
- [ ] Create EmptyState (inbox icon + text)
- [ ] Create MessageDetailSheet (bottom sheet with details)

- [ ] Verify: Each component matches original design

---

## Task 11: Senders Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/senders/SendersScreen.kt`
- Create: `app/src/main/java/com/piprapay/companion/ui/components/SenderCard.kt`

**Steps:**

- [ ] Create SendersScreen with "Update Senders" header
- [ ] Create SenderCard (name, toggle, description)
- [ ] Add placeholder sender list
- [ ] Add refresh button

- [ ] Verify: UI matches original screenshot

---

## Task 12: Analytics Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/analytics/AnalyticsScreen.kt`

**Steps:**

- [ ] Create AnalyticsScreen with "Simmery" card (keep typo for replica)
- [ ] Add pie chart placeholder (Stored, Used, Error counts)
- [ ] Match original layout

- [ ] Verify: UI matches original screenshot

---

## Task 13: Settings Screen

**Files:**
- Create: `app/src/main/java/com/piprapay/companion/ui/settings/SettingsScreen.kt`

**Steps:**

- [ ] Create SettingsScreen with user info card
- [ ] Add Service Status toggle
- [ ] Add SMS Permission toggle
- [ ] Add Battery optimization toggle
- [ ] Add "Delete SMS Data" row
- [ ] Add "Logout" row (red text)

- [ ] Verify: UI matches original screenshot

---

## Task 14: Wire Navigation

**Files:**
- Modify: `app/src/main/java/com/piprapay/companion/MainActivity.kt`
- Modify: `app/src/main/java/com/piprapay/companion/navigation/AppNavigation.kt`

**Steps:**

- [ ] Connect all screens in NavHost
- [ ] Add bottom nav bar to main scaffold
- [ ] Test full flow: Welcome → Permission → Login → Home → tabs

- [ ] Verify: Full navigation flow works

---

## Task 15: GitHub Actions Build

**Files:**
- Create: `.github/workflows/build.yml`

**Steps:**

- [ ] Create workflow for Android build
- [ ] Setup JDK 17, Gradle cache
- [ ] Run `./gradlew assembleDebug`
- [ ] Upload APK as artifact

- [ ] Verify: Workflow runs successfully

---

## Execution Handoff

**Two execution options:**

1. **Subagent-Driven (recommended)** — Fresh subagent per task, review between tasks
2. **Inline Execution** — Execute tasks in this session, batch with checkpoints

Which approach?
