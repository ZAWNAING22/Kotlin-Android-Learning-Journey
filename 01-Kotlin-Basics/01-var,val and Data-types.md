## What is Kotlin?

Kotlin is a modern programming language developed by JetBrains.

It is:

* ✅ **Officially supported for Android development** by Google
* ✅ Runs on the **JVM (Java Virtual Machine)**
* ✅ Fully **interoperable with Java** (you can use Java libraries in Kotlin)
* ✅ Designed to be **concise, safe, and expressive**

### Why Kotlin is popular (especially for Android)?

* Less boilerplate code than Java
* Built-in null safety
* Modern features (lambdas, coroutines, etc.)
* Clean and readable syntax

---

# 1️⃣ `val` vs `var` in Kotlin

In Kotlin, variables are declared using **`val`** or **`var`**.

---

## 🔹 `val` (Immutable – Read-only)

`val` means the variable **cannot be reassigned** after initialization.

```kotlin
val name = "Zaw"
name = "John"   // ❌ Error
```

Think of `val` like:

* A **constant reference**
* Similar to `final` in Java

### When to use `val`?

👉 Use `val` by default.
👉 Use it when the value should not change.

Example:

```kotlin
val pi = 3.14
val age = 25
```

---

## 🔹 `var` (Mutable – Changeable)

`var` means the variable **can be reassigned**.

```kotlin
var age = 25
age = 26   // ✅ Allowed
```

### When to use `var`?

👉 Use it only when the value needs to change.

Example:

```kotlin
var counter = 0
counter++
```

---

### 🔥 Best Practice (Very Important)

In Android/Kotlin development:

* ✅ Prefer `val`
* ❗ Use `var` only when necessary

Why?
Because **immutable code is safer and easier to debug**.

---

# 2️⃣ Data Types in Kotlin

Kotlin is **statically typed** → Every variable has a type.

You can write type explicitly:

```kotlin
val age: Int = 25
```

Or let Kotlin infer it:

```kotlin
val age = 25   // Kotlin automatically knows it's Int
```

---

## 🔹 1. Int

Whole numbers.

```kotlin
val number: Int = 10
```

---

## 🔹 2. Double

Decimal numbers.

```kotlin
val price: Double = 19.99
```

---

## 🔹 3. Float

Smaller decimal type (less precision than Double).

```kotlin
val temperature: Float = 36.5f
```

Note: Must add `f`.

---

## 🔹 4. Long

Large whole numbers.

```kotlin
val population: Long = 8000000000L
```

Must add `L` at end.

---

## 🔹 5. Boolean

True or False.

```kotlin
val isLoggedIn: Boolean = true
```

---

## 🔹 6. String

Text values.

```kotlin
val name: String = "Zaw"
```

### String templates (very powerful)

```kotlin
val age = 25
println("I am $age years old")
```

---

## 🔹 7. Char

Single character.

```kotlin
val grade: Char = 'A'
```

Note:

* Char uses **single quotes**
* String uses **double quotes**

---

# 💡 Quick Comparison Table

| Type    | Example |
| ------- | ------- |
| Int     | 10      |
| Double  | 10.5    |
| Float   | 10.5f   |
| Long    | 100L    |
| Boolean | true    |
| String  | "Hello" |
| Char    | 'A'     |

---

# 🧠 In Android Development

You’ll commonly use:

* `String` → TextView, EditText
* `Int` → Age, counters, IDs
* `Boolean` → Login state
* `Double` → Prices
* `val` → UI references, constants
* `var` → Mutable UI state


