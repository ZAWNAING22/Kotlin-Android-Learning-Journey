

# 📌 What is Console Input?

Console input means:

👉 The user types something in the terminal
👉 Your program reads that value

In Kotlin (JVM), we use:

```kotlin
readLine()
```

---

# 1️⃣ Basic Console Input

## 🔹 Reading a String

```kotlin
fun main() {
    println("Enter your name:")
    val name = readLine()
    println("Hello $name")
}
```

### How it works:

* `println()` → prints text
* `readLine()` → waits for user input
* Whatever user types → stored in variable

⚠ Important:
`readLine()` returns **String?** (nullable String)

We’ll explain that below.

---

# 2️⃣ Reading Numbers (Int, Double, etc.)

⚠ Important:

`readLine()` ALWAYS returns a **String**.

So if user enters:

```
25
```

It is still `"25"` (String)

You must convert it.

---

## 🔹 Convert to Int

```kotlin
fun main() {
    println("Enter your age:")
    val age = readLine()!!.toInt()
    println("Your age is $age")
}
```

### What is happening?

* `readLine()` → String?
* `!!` → tell Kotlin "I am sure it is not null"
* `toInt()` → convert String to Int

---

## 🔹 Convert to Double

```kotlin
val price = readLine()!!.toDouble()
```

---

# 3️⃣ Safer Way (Recommended)

Using `toIntOrNull()` to avoid crash:

```kotlin
fun main() {
    println("Enter a number:")
    val input = readLine()
    val number = input?.toIntOrNull()

    if (number != null) {
        println("You entered $number")
    } else {
        println("Invalid number")
    }
}
```

Why safer?

If user enters:

```
abc
```

`toInt()` → ❌ Crash
`toIntOrNull()` → returns `null` ✅

---

# 4️⃣ Multiple Inputs in One Line

User enters:

```
10 20
```

You can split it:

```kotlin
fun main() {
    println("Enter two numbers:")
    val input = readLine()!!
    val parts = input.split(" ")

    val a = parts[0].toInt()
    val b = parts[1].toInt()

    println("Sum = ${a + b}")
}
```

---

# 5️⃣ Why `readLine()` is Nullable?

Because it returns:

```kotlin
String?
```

The `?` means it might return `null`.

That’s why we use:

* `!!` (force not null)
* `?.`
* `toIntOrNull()`

This connects to Kotlin’s **null safety system**.

---

# 🧠 Important for (Android Student)

In Android:

You DON’T use `readLine()`.

Instead:

* You get input from `EditText`
* You convert using `.toString().toInt()`

Example:

```kotlin
val age = editText.text.toString().toInt()
```

So console input is just foundation training.

---

# 🚀 Example: Small Program

```kotlin
fun main() {
    println("Enter first number:")
    val a = readLine()!!.toInt()

    println("Enter second number:")
    val b = readLine()!!.toInt()

    println("Sum = ${a + b}")
}
```

---

# 📌 Summary

| Function        | Purpose                 |
| --------------- | ----------------------- |
| `readLine()`    | Read user input         |
| `toInt()`       | Convert String → Int    |
| `toDouble()`    | Convert String → Double |
| `toIntOrNull()` | Safe conversion         |
| `!!`            | Force not-null          |

---


Since you're building Kotlin foundation step-by-step, this is perfect timing to understand null safety deeply next.
