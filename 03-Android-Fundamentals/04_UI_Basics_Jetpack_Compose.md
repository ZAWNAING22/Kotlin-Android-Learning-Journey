

# 📱 UI Basics with Jetpack Compose

Modern Android UI is built using:

Jetpack Compose

It is developed by:

Google

Compose replaces XML with **Kotlin code for UI**.

---

# 1️⃣ What is Jetpack Compose?

Jetpack Compose is:

> A modern, declarative UI toolkit for Android.

Instead of writing UI in XML, you write UI directly in Kotlin.

Old way:

* XML + Kotlin

New way:

* Only Kotlin

---

# 2️⃣ Declarative UI (Very Important Concept)

Compose is **declarative**.

This means:

You describe **what the UI should look like**, not how to update it.

Example thinking:

> If state = LoggedIn → show Home
> If state = LoggedOut → show Login

Compose automatically updates UI when state changes.

---

# 3️⃣ Basic Composable Function

In Compose, UI is built using **@Composable functions**.

Example:

```kotlin
@Composable
fun Greeting() {
    Text(text = "Hello World")
}
```

To display it:

```kotlin
setContent {
    Greeting()
}
```

`setContent {}` replaces `setContentView()` from XML.

---

# 4️⃣ Basic Layout Example

```kotlin
@Composable
fun SimpleScreen() {
    Column {
        Text(text = "Welcome")
        Button(onClick = { }) {
            Text("Click Me")
        }
    }
}
```

### Common Layouts:

* `Column` → Vertical
* `Row` → Horizontal
* `Box` → Stack

---

# 5️⃣ State in Compose (Most Important Concept)

UI updates automatically when state changes.

Example:

```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text("Count: $count")

        Button(onClick = { count++ }) {
            Text("Increase")
        }
    }
}
```

When `count` changes → UI recomposes.

This is called:

> 🔁 Recomposition

---

# 6️⃣ Modifiers

Modifiers customize UI elements.

Example:

```kotlin
Text(
    text = "Hello",
    modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
)
```

Common modifiers:

* `padding`
* `fillMaxWidth`
* `size`
* `background`
* `clickable`

---

# 7️⃣ Preview in Android Studio

Compose allows preview without running app:

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    Greeting()
}
```

Very powerful for fast UI development.

---

# 8️⃣ Compose vs XML

| XML                | Compose              |
| ------------------ | -------------------- |
| Separate UI file   | UI written in Kotlin |
| Imperative updates | Declarative          |
| findViewById       | No view lookup       |
| More boilerplate   | Cleaner & shorter    |

Compose is now the recommended approach.

---

# 9️⃣ Real Practice Project (You Should Build This)

Create:

### 🧱 Simple Login Screen (Compose Version)

* Email TextField
* Password TextField
* Login Button
* Show message when clicked

Use:

* `Column`
* `TextField`
* `Button`
* `remember { mutableStateOf() }`

---

# 🔟 Why Compose Is Important for You

Since you already learned:

* Coroutines
* Flow
* StateFlow

Compose works perfectly with:

* ViewModel
* StateFlow
* Reactive state

This matches your Kotlin progress very well.

---

# 🧠 Key Concepts Learned

* What Compose is
* Declarative UI
* Composable functions
* State & recomposition
* Modifiers
* Preview

---

# 🏁 Summary

Jetpack Compose:

* Uses Kotlin for UI
* Is declarative
* Updates UI automatically on state change
* Is modern Android standard

If you master Compose + Coroutines + ViewModel
You are officially modern Android developer level.


