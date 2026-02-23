
---

# 1️⃣ Variables (`val` and `var`)

In Kotlin, variables store data.

### ✅ `val` → Read-only (cannot change)

Like `final` in Java.

```kotlin
val name = "Zaw"
name = "Ali"   // ❌ Error (cannot reassign)
```

### ✅ `var` → Mutable (can change)

```kotlin
var age = 22
age = 23   // ✅ Allowed
```

👉 Use `val` by default. Use `var` only if value needs to change.

---

# 2️⃣ Data Types

Kotlin is **strongly typed**.

### 🔹 Int (Whole numbers)

```kotlin
val number: Int = 10
```

### 🔹 String (Text)

```kotlin
val name: String = "Zaw Naing"
```

### 🔹 Boolean (true / false)

```kotlin
val isStudent: Boolean = true
```

### 🔹 Double (Decimal numbers)

```kotlin
val price: Double = 19.99
```

👉 Kotlin can **infer type automatically**:

```kotlin
val number = 10      // Kotlin knows it's Int
val name = "Zaw"     // Kotlin knows it's String
```

---

# 3️⃣ Functions

Functions perform actions.

### Basic Function

```kotlin
fun greet() {
    println("Hello!")
}
```

### Function with Parameters

```kotlin
fun greet(name: String) {
    println("Hello $name")
}
```

### Function with Return Value

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

Shortcut:

```kotlin
fun add(a: Int, b: Int) = a + b
```

---

# 4️⃣ Conditionals (`if`, `when`)

## ✅ `if` (like Java)

```kotlin
val age = 18

if (age >= 18) {
    println("Adult")
} else {
    println("Minor")
}
```

Kotlin `if` can return value:

```kotlin
val result = if (age >= 18) "Adult" else "Minor"
```

---

## ✅ `when` (better switch statement)

```kotlin
val day = 2

when (day) {
    1 -> println("Monday")
    2 -> println("Tuesday")
    else -> println("Other day")
}
```

More powerful than Java `switch`.

---

# 5️⃣ Loops

## ✅ `for` loop

```kotlin
for (i in 1..5) {
    println(i)
}
```

Output:

```
1 2 3 4 5
```

Loop through list:

```kotlin
val names = listOf("Ali", "Zaw", "John")

for (name in names) {
    println(name)
}
```

---

## ✅ `while` loop

```kotlin
var i = 1

while (i <= 5) {
    println(i)
    i++
}
```

---

# 6️⃣ Null Safety (`?`, `!!`)

🔥 Very important in Android.

Kotlin prevents NullPointerException.

### ❌ Normal variable (cannot be null)

```kotlin
var name: String = "Zaw"
name = null   // ❌ Error
```

---

### ✅ Nullable variable (`?`)

```kotlin
var name: String? = null
```

---

### Safe call operator `?.`

```kotlin
val length = name?.length
```

If `name` is null → result is null (no crash).

---

### Not-null assertion `!!` (dangerous ⚠)

```kotlin
val length = name!!.length
```

If `name` is null → 💥 Crash.

👉 Avoid `!!` in real apps.

---

# 7️⃣ Collections (List, Set, Map)

## ✅ List (Ordered, allows duplicates)

```kotlin
val numbers = listOf(1, 2, 3, 3)
```

Mutable list:

```kotlin
val numbers = mutableListOf(1, 2, 3)
numbers.add(4)
```

---

## ✅ Set (No duplicates)

```kotlin
val numbers = setOf(1, 2, 3, 3)
println(numbers)   // [1, 2, 3]
```

---

## ✅ Map (Key → Value pairs)

```kotlin
val student = mapOf(
    "name" to "Zaw",
    "age" to 22
)

println(student["name"])
```

Mutable:

```kotlin
val student = mutableMapOf<String, Int>()
student["Math"] = 90
```

---

# 🔥 Summary Table

| Concept | Purpose                     |
| ------- | --------------------------- |
| `val`   | Read-only variable          |
| `var`   | Mutable variable            |
| `if`    | Condition check             |
| `when`  | Multiple conditions         |
| `for`   | Loop through range/list     |
| `while` | Repeat while condition true |
| `?`     | Nullable type               |
| `List`  | Ordered collection          |
| `Set`   | Unique values               |
| `Map`   | Key-value pairs             |

---
 🔥 these are **very important Kotlin concepts**, especially for **modern Android development** (Jetpack, Compose, MVVM, etc.).explaination each clearly with examples and where it’s used in Android.

---

# 1️⃣ Lambda Functions

### ✅ What is a Lambda?

A **lambda** is an anonymous function (a function without a name).

Instead of writing:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

You can write:

```kotlin
val add = { a: Int, b: Int -> a + b }
```

Then call:

```kotlin
val result = add(5, 3)
```

---

### 🧠 Lambda Structure

```kotlin
{ parameter -> body }
```

Example:

```kotlin
val greet = { name: String -> "Hello $name" }
```

---

### 📱 Where used in Android?

Lambda is used **everywhere** in Android:

#### ✔ Button Click Listeners

```kotlin
button.setOnClickListener {
    println("Button clicked")
}
```

Instead of old Java style:

```kotlin
button.setOnClickListener(new View.OnClickListener() { ... })
```

---

#### ✔ RecyclerView click handling

#### ✔ API callbacks

#### ✔ LiveData observers

#### ✔ Coroutines

#### ✔ Jetpack Compose

Example in Compose:

```kotlin
Button(onClick = { /* action */ }) { }
```

👉 Lambdas make Android code shorter and cleaner.

---

# 2️⃣ Higher-Order Functions

### ✅ What is it?

A **higher-order function** is a function that:

* Takes another function as parameter
  OR
* Returns a function

---

### Example 1: Function as Parameter

```kotlin
fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
```

Using lambda:

```kotlin
val result = operate(5, 3) { x, y -> x + y }
```

---

### Example 2: Real Kotlin Example

`filter()` is a higher-order function:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

val evenNumbers = numbers.filter { it % 2 == 0 }
```

Here:

* `filter()` takes a lambda
* So it is a higher-order function

---

### 📱 Where used in Android?

Very common in:

* `setOnClickListener {}`
* `observe {}`
* `map {}`
* `filter {}`
* `forEach {}`
* Flow operators (`collect {}`)

Especially in:

* 🟢 MVVM architecture
* 🟢 Jetpack Compose
* 🟢 Coroutines Flow

---

# 3️⃣ Extension Functions

### ✅ What is it?

Extension function allows you to **add new functions to an existing class** without modifying it.

Very powerful Kotlin feature.

---

### Example

```kotlin
fun String.addExclamation(): String {
    return this + "!"
}
```

Use it like:

```kotlin
val text = "Hello"
println(text.addExclamation())
```

Even though `String` class didn’t originally have that function.

---

### 📱 Where used in Android?

Very common in Android.

Example:

```kotlin
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}
```

Then:

```kotlin
textView.visible()
```

Instead of:

```kotlin
textView.visibility = View.VISIBLE
```

---

### 🔥 Why Important?

* Cleaner code
* Reusable
* Used heavily in:

  * Android KTX
  * Jetpack libraries
  * Utility functions

---

# 4️⃣ Coroutines (VERY IMPORTANT 🚀🔥)

This is one of the most important topics in modern Android.

---

## ❓ What Problem Do Coroutines Solve?

Android cannot do long tasks on the main thread.

If you do:

* Network request
* Database query
* File reading

The app will freeze ❌

So we need background work.

Old way:

* AsyncTask (deprecated)
* Threads
* Callbacks (messy)

Now:
👉 We use **Coroutines**

---

## ✅ What is a Coroutine?

A coroutine is a lightweight thread for asynchronous programming.

It lets you write async code like normal code.

---

## Basic Example

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Hello after 1 second")
    }
}
```

---

### Important Keywords

| Keyword          | Meaning                 |
| ---------------- | ----------------------- |
| `suspend`        | Function that can pause |
| `launch`         | Start coroutine         |
| `async`          | Return result           |
| `delay()`        | Non-blocking delay      |
| `CoroutineScope` | Defines lifecycle       |

---

## Android Example (VERY IMPORTANT)

### API Call in ViewModel

```kotlin
viewModelScope.launch {
    val result = repository.getUsers()
    _users.value = result
}
```

Here:

* Runs in background
* Doesn’t freeze UI
* Safe lifecycle handling

---

## Dispatchers

Tell coroutine where to run:

```kotlin
Dispatchers.Main      // UI thread
Dispatchers.IO        // Network / Database
Dispatchers.Default   // Heavy CPU work
```

Example:

```kotlin
withContext(Dispatchers.IO) {
    // network call
}
```

---

## Why Coroutines Are Important in Android?

Used in:

* 🌐 Retrofit (network calls)
* 💾 Room database
* 🔄 Flow
* 📡 Firebase
* 📱 MVVM architecture
* 🎨 Jetpack Compose

Modern Android apps MUST use coroutines.

---

# 🔥 Quick Summary

| Concept      | What It Does            | Used Where               |
| ------------ | ----------------------- | ------------------------ |
| Lambda       | Anonymous function      | Click listeners, Compose |
| Higher-order | Function takes function | filter, map, observe     |
| Extension    | Add function to class   | View extensions          |
| Coroutines   | Async background tasks  | Network, DB, MVVM        |

---

# 🎯 For Your Kotlin Android Journey

Since you're learning Android seriously:

1. Master **Lambda** first
2. Then understand **Higher-order functions**
3. Practice **Extension functions**
4. Spend serious time on **Coroutines**

Coroutines = Professional Android Developer Level 🚀

---




