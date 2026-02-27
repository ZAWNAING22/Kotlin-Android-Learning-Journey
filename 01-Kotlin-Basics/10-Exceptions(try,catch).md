## ⚠️ Exceptions in Kotlin (try / catch / finally)

An **exception** is an error that happens while your program is running (runtime error).

Example:

* Dividing by zero
* Converting `"abc"` to number
* Accessing invalid array index

If not handled → app crashes 💥

---

# 1️⃣ Basic `try-catch`

### Syntax

```kotlin
try {
    // risky code
} catch (e: ExceptionType) {
    // handle error
}
```

---

### Example 1: Division by Zero

```kotlin
val a = 10
val b = 0

try {
    val result = a / b
    println(result)
} catch (e: ArithmeticException) {
    println("Cannot divide by zero!")
}
```

If error happens → it goes to `catch`.

---

# 2️⃣ Multiple Catch Blocks

You can handle different errors differently.

```kotlin
try {
    val number = "abc".toInt()
    println(number)
} catch (e: NumberFormatException) {
    println("Invalid number format")
} catch (e: Exception) {
    println("Some other error")
}
```

---

# 3️⃣ `finally` Block

`finally` always runs — whether error happens or not.

```kotlin
try {
    println("Trying...")
} catch (e: Exception) {
    println("Error occurred")
} finally {
    println("This always runs")
}
```

Commonly used for:

* Closing files
* Closing database connections
* Releasing resources

---

# 4️⃣ `try` as an Expression (Very Important in Kotlin)

Like `if`, `try` can return a value.

```kotlin
val result = try {
    "123".toInt()
} catch (e: NumberFormatException) {
    0
}

println(result)
```

If conversion fails → result becomes `0`.

Very clean and powerful 🔥

---

# 5️⃣ Throwing Exceptions (`throw`)

You can manually throw an exception.

```kotlin
fun checkAge(age: Int) {
    if (age < 18) {
        throw IllegalArgumentException("Underage")
    }
}
```

---

# 6️⃣ Custom Exception

```kotlin
class InvalidUserException(message: String) : Exception(message)
```

Use it:

```kotlin
throw InvalidUserException("User not found")
```

---

# 7️⃣ Checked vs Unchecked Exceptions

In Java, there are:

* Checked exceptions (must handle)
* Unchecked exceptions

Kotlin simplifies this:
👉 Kotlin does NOT force checked exceptions.

This is one reason Kotlin became popular when supported officially by
**Google** for Android development and created by **JetBrains**.

---

# 8️⃣ Real Android Example

```kotlin
val number = intent.getStringExtra("age")

val age = try {
    number?.toInt()
} catch (e: Exception) {
    null
}
```

Or safer way (without exception):

```kotlin
val age = number?.toIntOrNull()
```

👉 Kotlin provides many safe functions to reduce exceptions.

---

# 🚀 Best Practice in Kotlin

Instead of using exceptions too much:

✅ Use:

* `toIntOrNull()`
* `?.`
* `?:`
* `require()`
* `check()`

Exceptions should be used for:

* Unexpected errors
* Invalid states
* Business rule violations

Not for normal logic flow.

---

# 🎯 Summary

| Keyword   | Meaning               |
| --------- | --------------------- |
| `try`     | Wrap risky code       |
| `catch`   | Handle error          |
| `finally` | Always executes       |
| `throw`   | Manually create error |

---


