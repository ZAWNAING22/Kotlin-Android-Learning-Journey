## Material Design in Jetpack Compose

**Material Design** is Google’s UI design system for Android apps.
It provides:

* consistent UI components
* colors & typography
* animations
* responsive layouts
* accessibility support

In modern Android development, Jetpack Compose mainly uses **Material 3 (Material You)**.

---

# 📦 Material Design Libraries in Compose

You usually use:

```kotlin
implementation("androidx.compose.material3:material3")
```

Then import:

```kotlin
import androidx.compose.material3.*
```

---

# 🎨 Core Material Design Concepts

## 1. Colors (Color Scheme)

Material uses a color system for:

* Primary color
* Secondary color
* Background
* Surface
* Error colors

Example:

```kotlin
MaterialTheme(
    colorScheme = lightColorScheme(
        primary = Color.Blue,
        secondary = Color.Cyan
    )
) {
    // UI here
}
```

---

## 2. Typography

Controls text styles:

* headline
* title
* body
* label

Example:

```kotlin
Text(
    text = "Hello",
    style = MaterialTheme.typography.headlineMedium
)
```

---

## 3. Shapes

Controls rounded corners.

Example:

```kotlin
Card(
    shape = RoundedCornerShape(16.dp)
)
```

---

# 🧩 Common Material Components in Compose

---

## Button

```kotlin
Button(onClick = {}) {
    Text("Login")
}
```

### Types of Buttons

* `Button`
* `OutlinedButton`
* `TextButton`
* `ElevatedButton`
* `FilledTonalButton`

---

## TextField

```kotlin
OutlinedTextField(
    value = name,
    onValueChange = { name = it },
    label = { Text("Name") }
)
```

---

## Card

Used to group UI content.

```kotlin
Card {
    Text("Profile")
}
```

---

## Scaffold

Provides app structure.

Usually contains:

* TopBar
* BottomBar
* FloatingActionButton
* Content

```kotlin
Scaffold(
    topBar = {
        TopAppBar(
            title = { Text("Dashboard") }
        )
    }
) { padding ->
    
}
```

---

## TopAppBar

Toolbar/Header.

```kotlin
TopAppBar(
    title = { Text("Home") }
)
```

---

## Bottom Navigation

Used for navigation tabs.

```kotlin
NavigationBar {
    NavigationBarItem(
        selected = true,
        onClick = {},
        icon = { Icon(Icons.Default.Home, null) },
        label = { Text("Home") }
    )
}
```

---

## Floating Action Button (FAB)

```kotlin
FloatingActionButton(
    onClick = {}
) {
    Icon(Icons.Default.Add, null)
}
```

---

## Snackbar

Temporary message.

```kotlin
Snackbar {
    Text("Saved Successfully")
}
```

---

## Dialog

Popup window.

```kotlin
AlertDialog(
    onDismissRequest = {},
    confirmButton = {},
    title = { Text("Delete") },
    text = { Text("Are you sure?") }
)
```

---

# 📐 Material Theme

Compose apps usually wrap everything with:

```kotlin
MaterialTheme {

}
```

This applies:

* colors
* typography
* shapes

to the whole app.

---

# 🌙 Dark Mode Support

Material 3 supports dark mode easily.

Example:

```kotlin
val colors = if (darkTheme) {
    darkColorScheme()
} else {
    lightColorScheme()
}
```

---

# 📱 Material Design in Real Apps

Most real apps use Material components because they:

* look professional
* are responsive
* follow Android standards
* reduce UI coding effort
* support accessibility automatically

Examples:

* login screens
* dashboards
* settings pages
* chat apps
* e-commerce apps

---

# 🔥 Material 2 vs Material 3

| Material 2          | Material 3      |
| ------------------- | --------------- |
| Older design system | Modern system   |
| Fixed colors        | Dynamic colors  |
| Less customization  | More flexible   |
| Old Compose apps    | Recommended now |

Use **Material 3** for new projects.

---

# 🧠 Important Material Components to Learn First

For your Jetpack Compose roadmap, focus on:

1. `Button`
2. `TextField`
3. `Card`
4. `Scaffold`
5. `TopAppBar`
6. `NavigationBar`
7. `LazyColumn`
8. `Snackbar`
9. `Dialog`
10. `MaterialTheme`

These are used in almost every Android app. 
