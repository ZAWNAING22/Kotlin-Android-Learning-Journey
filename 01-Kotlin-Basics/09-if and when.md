## 🔹 Conditionals in Kotlin: `if` and `when`

These are used to make decisions in your program.

---

# 1️⃣ `if` Statement

### Basic Syntax

```kotlin
if (condition) {
    // code
}
```

### Example

```kotlin
val age = 20

if (age >= 18) {
    println("Adult")
}
```

---

## 🔹 `if - else`

```kotlin
val age = 16

if (age >= 18) {
    println("Adult")
} else {
    println("Minor")
}
```

---

## 🔹 `if - else if - else`

```kotlin
val marks = 75

if (marks >= 90) {
    println("Grade A")
} else if (marks >= 70) {
    println("Grade B")
} else {
    println("Grade C")
}
```

---

## ✅ Important: `if` is an **expression** in Kotlin

In Kotlin, `if` can return a value.

```kotlin
val age = 20

val result = if (age >= 18) "Adult" else "Minor"

println(result)
```

No need for ternary operator like Java (`? :`) — Kotlin doesn’t need it.

---

# 2️⃣ `when` Expression (Very Powerful)

`when` is like a better version of `switch` in Java.

---

## 🔹 Basic Example

```kotlin
val day = 3

when (day) {
    1 -> println("Monday")
    2 -> println("Tuesday")
    3 -> println("Wednesday")
    else -> println("Invalid day")
}
```

---

## 🔹 Multiple Conditions in One Line

```kotlin
val day = 6

when (day) {
    1, 2, 3, 4, 5 -> println("Weekday")
    6, 7 -> println("Weekend")
}
```

---

## 🔹 Using `when` as Expression (Return Value)

```kotlin
val day = 2

val result = when (day) {
    1 -> "Mon"
    2 -> "Tue"
    else -> "Unknown"
}

println(result)
```

---

## 🔹 Using Ranges

```kotlin
val score = 85

when (score) {
    in 90..100 -> println("A")
    in 70..89 -> println("B")
    in 50..69 -> println("C")
    else -> println("Fail")
}
```

---

## 🔹 Using Conditions (Without Argument)

```kotlin
val age = 20

when {
    age < 13 -> println("Child")
    age < 18 -> println("Teen")
    else -> println("Adult")
}
```

Here `when` works like multiple `if` statements.

---

# 🔥 `if` vs `when`

| `if`                | `when`                          |
| ------------------- | ------------------------------- |
| Simple conditions   | Multiple branches               |
| Good for 2–3 checks | Cleaner for many cases          |
| Used often          | More readable for complex logic |

---

# 🎯 In Android Development

You’ll use:

* `if` → checking null, checking login status, permissions
* `when` → handling UI states, API responses, button clicks, navigation states

Example:

```kotlin
when (response) {
    is Success -> showData()
    is Error -> showError()
    is Loading -> showLoading()
}
```

Very common in **Jetpack Compose** and **MVVM architecture**.

---

