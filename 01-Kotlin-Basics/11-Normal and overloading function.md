# 🔹 Normal Functions in Kotlin

A **function** is a block of reusable code that performs a specific task.

---

## 1️⃣ Basic Syntax

```kotlin
fun functionName(parameters): ReturnType {
    // code
    return value
}
```

---

## 2️⃣ Simple Function Example

```kotlin
fun greet() {
    println("Hello")
}
```

Call it:

```kotlin
greet()
```

---

## 3️⃣ Function with Parameters

```kotlin
fun greet(name: String) {
    println("Hello $name")
}
```

Call:

```kotlin
greet("John")
```

---

## 4️⃣ Function with Return Type

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

Usage:

```kotlin
val result = add(5, 3)
println(result)
```

---

## 5️⃣ Single Expression Function (Short Form)

If function has one expression:

```kotlin
fun add(a: Int, b: Int): Int = a + b
```

Cleaner and commonly used in modern Kotlin.

---

## 6️⃣ Default Parameter Values

```kotlin
fun greet(name: String = "Guest") {
    println("Hello $name")
}
```

Call:

```kotlin
greet()          // Hello Guest
greet("Alice")   // Hello Alice
```

Very useful in Android development.

---

# 🔹 Function Overloading

Function overloading means:

👉 **Same function name**
👉 **Different parameters** (number or type)

Kotlin decides which one to call based on arguments.

---

## 1️⃣ Example: Different Parameter Count

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}
```

Usage:

```kotlin
add(2, 3)       // calls first function
add(2, 3, 4)    // calls second function
```

---

## 2️⃣ Example: Different Parameter Types

```kotlin
fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun multiply(a: Double, b: Double): Double {
    return a * b
}
```

Kotlin chooses based on argument type.

---

# ⚠️ Important Rules

You CANNOT overload based only on return type.

❌ Not allowed:

```kotlin
fun test(a: Int): Int
fun test(a: Int): Double   // Error
```

Because parameters are same.

---

# 🔥 Overloading vs Default Parameters

Sometimes you don't need overloading because Kotlin supports default values.

Instead of:

```kotlin
fun greet()
fun greet(name: String)
```

You can write:

```kotlin
fun greet(name: String = "Guest")
```

Cleaner and more Kotlin-style ✅

---

# 🎯 In Android Development

You use functions for:

* Button click logic
* API calls
* Database operations
* Utility helpers

Overloading is used in:

* Constructors
* Custom view setup
* Utility classes

Example:

```kotlin
fun showMessage(message: String)
fun showMessage(message: String, duration: Int)
```

---

# 📌 Summary

## Normal Function

* Defined using `fun`
* Can have parameters
* Can return value
* Can be single-expression

## Function Overloading

* Same name
* Different parameters
* Not based on return type
* Kotlin prefers default parameters instead of too many overloads

---

