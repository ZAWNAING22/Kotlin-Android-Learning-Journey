
---

# 1️⃣ Delegated Properties (`by` keyword)

Delegation means:

> “Let another object handle this property’s logic.”

Instead of managing the value yourself, you delegate it to something else using **`by`**.

---

## 🔹 Basic Idea

```kotlin
val name by lazy {
    "Zaw"
}
```

Here:

* `name` is not created immediately.
* It is created **only when first used**.
* `lazy` handles the logic.
* `by` delegates the work to `lazy`.

---

## 🔹 Example 1: `lazy`

```kotlin
val message: String by lazy {
    println("Initialized!")
    "Hello"
}

fun main() {
    println(message)  // Now initialized
}
```

Output:

```
Initialized!
Hello
```

---

## 🔹 Example 2: Android (Very Important)

### 🔹 `by viewModels()` (MVVM)

```kotlin
private val viewModel: MainViewModel by viewModels()
```

Here:

* The Activity doesn’t create the ViewModel manually.
* `viewModels()` handles lifecycle.
* Cleaner and safer.

---

## 🔹 Example 3: Jetpack Compose `remember`

```kotlin
val count by remember { mutableStateOf(0) }
```

Here:

* `remember` keeps state during recomposition.
* `by` removes `.value` usage.
* Instead of `count.value`, you just use `count`.

Without `by`:

```kotlin
val count = remember { mutableStateOf(0) }
count.value++
```

With `by`:

```kotlin
var count by remember { mutableStateOf(0) }
count++
```

Cleaner ✅

---

## 🔥 Why Delegation is Powerful?

It is used for:

* Lazy initialization
* State management
* ViewModel handling
* SharedPreferences
* Custom property logic

---

# 2️⃣ Destructuring Declarations

Destructuring means:

> Breaking an object into separate variables.

---

## 🔹 With Data Class

```kotlin
data class User(val id: Int, val name: String)

val user = User(1, "Zaw")

val (id, name) = user

println(id)   // 1
println(name) // Zaw
```

Kotlin automatically generates:

```kotlin
component1()
component2()
```

That’s why destructuring works.

---

## 🔹 In Loops (Very Common)

```kotlin
val users = listOf(
    User(1, "Ali"),
    User(2, "Veli")
)

for ((id, name) in users) {
    println("$id - $name")
}
```

Very clean 👌

---

# 3️⃣ Pair and Triple

Sometimes you need to return multiple values but don’t want to create a full data class.

Kotlin gives:

* `Pair` → 2 values
* `Triple` → 3 values

---

## 🔹 Pair Example

```kotlin
val result: Pair<Int, String> = Pair(1, "Success")

println(result.first)
println(result.second)
```

Better way:

```kotlin
val result = 1 to "Success"
```

Destructuring:

```kotlin
val (code, message) = result
```

---

## 🔹 Triple Example

```kotlin
val triple = Triple(1, "Zaw", true)

val (id, name, isActive) = triple
```

---

## ⚠️ When NOT to Use Pair/Triple

If the data has meaning:

❌ Bad:

```kotlin
fun getUser(): Pair<Int, String>
```

You don’t know what values mean.

✅ Better:

```kotlin
data class User(val id: Int, val name: String)
```

Use `Pair/Triple` only for:

* Temporary values
* Simple utility returns

---

# 4️⃣ Type Aliases

Typealias creates a **nickname for complex types**.

---

## 🔹 Without Typealias

```kotlin
val users: Map<Int, User>
```

If used many times, it becomes messy.

---

## 🔹 With Typealias

```kotlin
typealias UserMap = Map<Int, User>

val users: UserMap
```

Now it is cleaner and more readable.

---

## 🔹 Very Useful for Function Types

```kotlin
typealias OnClick = (String) -> Unit
```

Instead of:

```kotlin
val clickListener: (String) -> Unit
```

You can write:

```kotlin
val clickListener: OnClick
```

Very common in Android UI.

---

# 🎯 Where These Are Used in Android

| Concept              | Where Used                                |
| -------------------- | ----------------------------------------- |
| Delegated properties | `viewModels()`, `remember`, `lazy`, state |
| Destructuring        | Lists, Maps, Data classes                 |
| Pair / Triple        | Returning temporary values                |
| Typealias            | Cleaner architecture, callback types      |

---

# 🔥 Quick Summary

| Concept       | Purpose                                |
| ------------- | -------------------------------------- |
| `by`          | Delegate logic to another object       |
| Destructuring | Break object into variables            |
| Pair/Triple   | Hold 2–3 values quickly                |
| Typealias     | Create cleaner names for complex types |

---

