# 📦 Data Classes in Kotlin

A **data class** is a special type of class used to store data.

It automatically provides useful functions like:

* `toString()`
* `equals()`
* `hashCode()`
* `copy()`
* `componentN()` (for destructuring)

This makes your code shorter and cleaner 🚀

---

# 🔹 1️⃣ Basic Syntax

```kotlin
data class User(val name: String, val age: Int)
```

That’s it. Kotlin automatically generates everything needed.

---

# 🔹 2️⃣ Why Not Normal Class?

### Normal Class:

```kotlin
class User(val name: String, val age: Int)
```

If you print it:

```kotlin
val user = User("John", 25)
println(user)
```

Output:

```
User@6d06d69c
```

Not useful 😅

---

### Data Class:

```kotlin
data class User(val name: String, val age: Int)
```

Now:

```kotlin
val user = User("John", 25)
println(user)
```

Output:

```
User(name=John, age=25)
```

Much better ✅

---

# 🔹 3️⃣ `equals()` Automatically Works

```kotlin
val u1 = User("John", 25)
val u2 = User("John", 25)

println(u1 == u2)   // true
```

Data classes compare values, not memory address.

---

# 🔹 4️⃣ `copy()` Function (Very Powerful)

```kotlin
val u1 = User("John", 25)
val u2 = u1.copy(age = 30)

println(u2)
```

Output:

```
User(name=John, age=30)
```

Useful when working with immutable objects (very common in Android & MVVM).

---

# 🔹 5️⃣ Destructuring Declaration

```kotlin
val user = User("Alice", 22)

val (name, age) = user

println(name)  // Alice
println(age)   // 22
```

This works because Kotlin generates `component1()`, `component2()` automatically.

---

# 🔹 6️⃣ Rules of Data Class

1. Must have at least one parameter.
2. Parameters must be `val` or `var`.
3. Cannot be abstract, open, sealed, or inner.

---

# 🔥 Why Data Classes Are Important?

They are heavily used in:

* API response models
* Database entities
* UI state models
* JSON mapping
* RecyclerView items

Example in Android:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

When working with APIs or Room database, you mostly use data classes.

---

# 🎯 Real Android Example

```kotlin
data class UserUiState(
    val isLoading: Boolean,
    val data: List<String>,
    val error: String?
)
```

Very common in MVVM architecture and Jetpack Compose.

Kotlin was created by **JetBrains** and officially supported for Android by **Google**, and data classes are one reason Android code became much cleaner compared to Java.

---

# 📌 Data Class vs Normal Class

| Normal Class        | Data Class     |
| ------------------- | -------------- |
| Manual `toString()` | Auto-generated |
| Manual `equals()`   | Auto-generated |
| No `copy()`         | Has `copy()`   |
| More boilerplate    | Very concise   |

---

# 🚀 Summary

A data class:

* Is used to hold data
* Automatically generates useful functions
* Makes Android code clean and modern
* Is essential in MVVM, APIs, databases

---


