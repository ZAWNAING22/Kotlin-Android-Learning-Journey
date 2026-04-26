## 📌 State and State Management in Jetpack Compose

In **Jetpack Compose**, **UI is driven by state**.

That means:

> When **state changes**, Compose automatically **rebuilds (recomposes)** the UI.

This is one of the biggest differences from XML Android UI.

---

# 🔹 What is State?

State = any data that can change and affect UI.

Examples:

* Counter value
* TextField input
* Checkbox checked / unchecked
* Loading status
* List of items
* Selected tab

---

## Example Without State

```kotlin
@Composable
fun Counter() {
    var count = 0

    Button(onClick = { count++ }) {
        Text("$count")
    }
}
```

❌ Won’t work properly because Compose doesn't observe normal variables.

---

# ✅ Correct Way: Mutable State

```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("$count")
    }
}
```

### How it works:

* `mutableStateOf(0)` → creates observable state
* `remember {}` → keeps value during recomposition
* when `count++`
* UI updates automatically

---

# 🔹 State Flow in Compose

```text
State changes
      ↓
Compose detects change
      ↓
Recomposition happens
      ↓
UI redraws only needed parts
```

---

# 🔹 Important Terms

---

## 1️⃣ remember

Keeps state while composable stays on screen.

```kotlin
var text by remember { mutableStateOf("") }
```

Without `remember`, value resets every recomposition.

---

## 2️⃣ mutableStateOf()

Creates changeable state.

```kotlin
mutableStateOf(0)
```

---

## 3️⃣ by Delegation

Cleaner syntax:

```kotlin
var count by remember { mutableStateOf(0) }
```

Instead of:

```kotlin
val count = remember { mutableStateOf(0) }
count.value++
```

---

# 🔹 Example: TextField State

```kotlin
@Composable
fun NameInput() {
    var name by remember { mutableStateOf("") }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it }
        )

        Text("Hello $name")
    }
}
```

When user types → state changes → text updates instantly.

---

# 🔹 State Hoisting (Very Important)

Best practice: Move state up to parent.

---

## ❌ Bad

```kotlin
@Composable
fun Child() {
   var text by remember { mutableStateOf("") }
}
```

---

## ✅ Good

```kotlin
@Composable
fun Parent() {
    var text by remember { mutableStateOf("") }

    Child(
        value = text,
        onValueChange = { text = it }
    )
}

@Composable
fun Child(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange
    )
}
```

---

## Why?

Because parent controls state.

Benefits:

✅ Reusable
✅ Testable
✅ Cleaner architecture

---

# 🔹 Stateless vs Stateful Composable

---

## Stateful

Manages own state.

```kotlin
@Composable
fun Counter() {
   var count by remember { mutableStateOf(0) }
}
```

---

## Stateless

Receives state + event.

```kotlin
@Composable
fun Counter(
   count: Int,
   onIncrement: () -> Unit
)
```

Preferred in real apps.

---

# 🔹 rememberSaveable

Keeps state even after rotation.

```kotlin
var name by rememberSaveable {
    mutableStateOf("")
}
```

Use for:

* Text input
* Selected tab
* UI temporary data

---

# 🔹 ViewModel State Management

For real apps use `ViewModel`

```kotlin
class CounterViewModel : ViewModel() {
    var count by mutableStateOf(0)
        private set

    fun increase() {
        count++
    }
}
```

Composable:

```kotlin
@Composable
fun Screen(vm: CounterViewModel = viewModel()) {
    Button(onClick = { vm.increase() }) {
        Text("${vm.count}")
    }
}
```

---

# 🔹 Real App State Examples

### UI State

* Dialog open/close
* TextField value
* Checkbox checked

### Screen State

* Loading
* Success
* Error

### Data State

* User profile
* Product list
* Notes list

---

# 🔹 Best Practice Architecture

```text
UI (Composable)
   ↓ events
ViewModel
   ↓ state
Compose UI observes state
```

---

# 🔹 Compose Recomposition Rule

Only parts reading changed state recomposes.

Efficient and fast.

---

# 🔹 Summary Table

| Concept            | Meaning                         |
| ------------------ | ------------------------------- |
| `mutableStateOf()` | observable state                |
| `remember`         | keep state during recomposition |
| `rememberSaveable` | survive rotation                |
| State Hoisting     | move state to parent            |
| ViewModel          | screen state holder             |
| Recomposition      | UI refresh                      |

---

# 🔥 Most Important Interview Question

### Why state is important in Compose?

Because Compose is **declarative UI**.

You describe UI based on state:

```kotlin
if (loggedIn)
   ShowHome()
else
   ShowLogin()
```

State changes → UI changes automatically.

---

# 🔥 If you're learning Jetpack Compose roadmap:

After this topic learn:

1. Recomposition deeply
2. remember vs rememberSaveable
3. ViewModel + StateFlow
4. MVVM in Compose
5. Side effects (`LaunchedEffect`)
6. Navigation state

---

