

# 📱 Navigation in Jetpack Compose

Modern Android navigation is handled using:

Android Jetpack
Specifically the **Navigation Component** for
Jetpack Compose

Navigation allows you to move between screens cleanly and safely.

---

# 1️⃣ Why Navigation Is Needed

Without navigation:

* You manually manage screen switching
* Hard to manage back stack
* Difficult to pass data
* Error-prone

Navigation component handles:

✔ Screen transitions
✔ Back button behavior
✔ Argument passing
✔ Back stack management

---

# 2️⃣ Add Navigation Dependency

In `build.gradle`:

```kotlin
implementation("androidx.navigation:navigation-compose:2.7.7")
```

---

# 3️⃣ Basic Navigation Setup

### Step 1: Create NavController

```kotlin
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailsScreen() }
    }
}
```

---

# 4️⃣ Navigate Between Screens

### 🔹 Home Screen

```kotlin
@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate("details")
    }) {
        Text("Go to Details")
    }
}
```

### 🔹 Details Screen

```kotlin
@Composable
fun DetailsScreen() {
    Text("This is Details Screen")
}
```

---

# 5️⃣ Passing Arguments Between Screens

Define route with argument:

```kotlin
composable("details/{username}") { backStackEntry ->
    val name = backStackEntry.arguments?.getString("username")
    DetailsScreen(name)
}
```

Navigate with value:

```kotlin
navController.navigate("details/John")
```

Receive in screen:

```kotlin
@Composable
fun DetailsScreen(name: String?) {
    Text("Hello $name")
}
```

---

# 6️⃣ Back Navigation

Go back:

```kotlin
navController.popBackStack()
```

Android system back button works automatically.

---

# 7️⃣ Recommended Clean Structure (Professional Way)

Instead of hardcoding strings:

```kotlin
object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
}
```

Use:

```kotlin
navController.navigate(Routes.DETAILS)
```

This prevents typo bugs.

---

# 8️⃣ Navigation with ViewModel

Important rule:

Each screen can have its own ViewModel:

```kotlin
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel())
```

Navigation does NOT destroy ViewModel unless screen leaves back stack permanently.

This works smoothly with:

* StateFlow
* Coroutines
* Compose state

---

# 9️⃣ Real Practice Project (You Should Build This)

Create:

### 🧱 2-Screen App

HomeScreen:

* TextField (enter name)
* Button

DetailsScreen:

* Show entered name

Use:

* Navigation
* Argument passing
* StateFlow in ViewModel

This completes your basic app structure.

---

# 🔟 Common Beginner Mistakes

❌ Hardcoding route strings everywhere
❌ Passing large objects instead of IDs
❌ Creating NavController outside Compose
❌ Forgetting to manage back stack

---

# 🧠 Key Concepts Learned

* NavController
* NavHost
* Composable routes
* Passing arguments
* Back stack management
* Clean routing structure

---

# 🏁 Summary

Navigation in Compose:

* Manages screen transitions
* Handles back stack automatically
* Supports argument passing
* Works perfectly with ViewModel & StateFlow

At this point, you can build:

✔ Multi-screen apps
✔ State-managed UI
✔ Lifecycle-aware architecture

You are now officially beyond beginner Android level.


Say “go” when ready.
