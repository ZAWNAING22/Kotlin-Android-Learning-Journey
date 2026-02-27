# 🔹 Extension Functions in Kotlin

Extension functions allow you to **add new functions to an existing class**
without modifying its source code.

Very powerful feature in Kotlin 🚀

---

## 1️⃣ Basic Syntax

```kotlin
fun ClassName.functionName(): ReturnType {
    // code
}
```

---

## 2️⃣ Simple Example

```kotlin
fun String.greet() {
    println("Hello $this")
}
```

Use it like this:

```kotlin
val name = "John"
name.greet()
```

Even though `String` class is not yours, you added a new function to it.

👉 `this` refers to the object calling the function.

---

## 3️⃣ Extension Function with Return Value

```kotlin
fun String.firstChar(): Char {
    return this[0]
}
```

Usage:

```kotlin
val letter = "Kotlin".firstChar()
println(letter)   // K
```

---

## 4️⃣ Extension with Parameters

```kotlin
fun Int.isEven(): Boolean {
    return this % 2 == 0
}
```

Usage:

```kotlin
println(4.isEven())   // true
```

---

## ⚠️ Important Rules

1. Extension functions do NOT actually modify the class.
2. They cannot access private members of the class.
3. They are resolved at compile time (not runtime polymorphism).

---

## 🔥 Why Extension Functions Are Important?

Kotlin uses them everywhere.

Example:
`toIntOrNull()` is an extension function on `String`.

Kotlin was created by **JetBrains** and officially supported for Android by **Google**, and extension functions are heavily used in Android libraries.

---

# 🔹 Lambda Functions in Kotlin

A **lambda** is an anonymous function (function without a name).

Used heavily in:

* Collections
* Higher-order functions
* Android click listeners
* Coroutines

---

## 1️⃣ Basic Lambda Syntax

```kotlin
{ parameters -> body }
```

---

## 2️⃣ Simple Lambda Example

```kotlin
val greet = { println("Hello") }

greet()
```

---

## 3️⃣ Lambda with Parameters

```kotlin
val add = { a: Int, b: Int -> a + b }

println(add(5, 3))   // 8
```

---

## 4️⃣ Lambda with Return Type (Implicit)

Last line is automatically returned.

```kotlin
val square: (Int) -> Int = { x -> x * x }

println(square(4))   // 16
```

`(Int) -> Int` means:
Takes Int → Returns Int

---

## 5️⃣ Very Common Example (Collections)

```kotlin
val numbers = listOf(1, 2, 3, 4)

val doubled = numbers.map { it * 2 }

println(doubled)
```

`it` = default name for single parameter.

---

## 6️⃣ Lambda as Function Parameter (Higher-Order Function)

```kotlin
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
```

Call it:

```kotlin
val result = calculate(4, 5) { x, y -> x + y }
println(result)
```

Very powerful 🔥

---

# 🔥 Extension vs Lambda (Difference)

| Extension Function              | Lambda Function                 |
| ------------------------------- | ------------------------------- |
| Adds function to existing class | Anonymous function              |
| Declared using `fun`            | Declared using `{}`             |
| Used for utility methods        | Used for functional programming |
| Resolved at compile time        | Can be passed as variable       |

---

# 🎯 In Android Development

### Extension Functions:

* Simplify View code
* Format strings
* Utility helpers

Example:

```kotlin
fun View.visible() {
    this.visibility = View.VISIBLE
}
```

---

### Lambda Functions:

* Button click listeners
* RecyclerView adapters
* Coroutines
* LiveData observers

Example:

```kotlin
button.setOnClickListener {
    println("Clicked")
}
```

Very common in modern Android (especially Jetpack Compose).

---

# 📌 Summary

## Extension Function

* Adds new function to existing class
* Cleaner utility code
* Used everywhere in Kotlin libraries

## Lambda Function

* Anonymous function
* Can be stored in variable
* Can be passed as parameter
* Core part of functional programming

---


