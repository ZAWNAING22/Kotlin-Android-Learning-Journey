# Navigation in Jetpack Compose

In **Jetpack Compose**, navigation means moving between different **screens (composables)** inside your app.

Instead of using old XML + Fragment navigation, Compose uses **Navigation Compose**.

---

## 🚀 Why Navigation is Needed?

Apps usually have many screens:

* Login Screen
* Home Screen
* Detail Screen
* Settings Screen

You need a way to move between them.

Example:

`Login → Home → Profile → Back`

---

## 📦 Dependency

Add navigation library in `build.gradle.kts`

```kotlin
implementation("androidx.navigation:navigation-compose:2.8.0")
```

(Use latest stable version in your project.)

---

# Core Concepts

## 1️⃣ NavController

Controls navigation.

Like a manager that says:

* Go to Home
* Go back
* Open Detail screen

```kotlin
val navController = rememberNavController()
```

---

## 2️⃣ NavHost

Container that holds all destinations (screens).

```kotlin
NavHost(
    navController = navController,
    startDestination = "home"
) {
}
```

---

## 3️⃣ Composable Destinations

Each screen is registered inside `NavHost`.

```kotlin
composable("home") { HomeScreen() }
composable("profile") { ProfileScreen() }
```

---

# Full Basic Example

```kotlin
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController)
        }
    }
}
```

---

# Home Screen

```kotlin
@Composable
fun HomeScreen(navController: NavController) {

    Column {
        Text("Home Screen")

        Button(onClick = {
            navController.navigate("profile")
        }) {
            Text("Go Profile")
        }
    }
}
```

---

# Profile Screen

```kotlin
@Composable
fun ProfileScreen(navController: NavController) {

    Column {
        Text("Profile Screen")

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }
    }
}
```

---

# Flow Visualization




---

# Important Functions

## Navigate to screen

```kotlin
navController.navigate("profile")
```

---

## Back to previous screen

```kotlin
navController.popBackStack()
```

---

## Clear previous stack

Used after login.

```kotlin
navController.navigate("home") {
    popUpTo("login") { inclusive = true }
}
```

Means:

Remove login screen from backstack.

---

# Passing Data Between Screens

Example: open detail page with id.

```kotlin
navController.navigate("detail/5")
```

Register:

```kotlin
composable("detail/{id}") { backStackEntry ->

    val id = backStackEntry.arguments?.getString("id")

    DetailScreen(id)
}
```

---

# Better Route Management

Use object or sealed class.

```kotlin
object Routes {
    const val HOME = "home"
    const val PROFILE = "profile"
}
```

Use:

```kotlin
navController.navigate(Routes.PROFILE)
```

---

# Real App Structure

```kotlin
MainActivity
 └── setContent
      └── AppNavigation()
           ├── LoginScreen
           ├── HomeScreen
           ├── DetailScreen
           └── SettingsScreen
```

---

# Best Practice (Very Important)

## Pass NavController OR Lambda?

Better:

```kotlin
HomeScreen(
   onProfileClick = {
      navController.navigate("profile")
   }
)
```

Instead of passing `navController` everywhere.

Because screen becomes reusable/testable.

---

# Common Interview Question

## Difference:

### NavHost

Where screens live.

### NavController

Who controls movement.

---

# Beginner Summary

| Term           | Meaning                  |
| -------------- | ------------------------ |
| NavController  | Controls screen movement |
| NavHost        | Holds all screens        |
| composable()   | Register screen          |
| navigate()     | Go screen                |
| popBackStack() | Back                     |

---

# For Your Android Journey 📱

Since you're learning Compose, next after navigation learn:

1. Bottom Navigation
2. Passing arguments
3. Nested Navigation
4. MVVM + Navigation
5. Deep Links

---

# Real Example Apps Use Navigation

* Instagram → Home/Profile/Reels
* WhatsApp → Chats/Calls/Settings
* Food Delivery → Home/Cart/Order Tracking

---
