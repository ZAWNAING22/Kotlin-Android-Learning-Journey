 👍 this is core Kotlin foundation.

We’ll cover:

1. `print()`
2. `println()`
3. Hello World
4. `$` in string
5. `${}` in string

---

# 1️⃣ `print()` vs `println()`

Both are used to display output on the console.

---

## 🔹 `print()`

Prints text **without moving to a new line**.

```kotlin
fun main() {
    print("Hello ")
    print("World")
}
```

Output:

```
Hello World
```

Everything appears on the same line.

---

## 🔹 `println()`

Prints text **and moves to a new line**.

```kotlin
fun main() {
    println("Hello")
    println("World")
}
```

Output:

```
Hello
World
```

---

# 2️⃣ Hello World Program

This is the first program in almost every language.

```kotlin
fun main() {
    println("Hello World")
}
```

### Explanation:

* `fun` → keyword to declare function
* `main()` → starting point of program
* `{ }` → function body
* `println()` → prints text
* `"Hello World"` → String

When you run it → it prints the message.

---

# 3️⃣ String in Kotlin

String is written in double quotes:

```kotlin
val name = "Zaw"
```

Now Kotlin has something powerful called:

# 🔥 String Templates

This is where `$` and `${}` come in.

---

# 4️⃣ `$` in String (Variable Insertion)

You use `$` to insert a variable inside a string.

```kotlin
fun main() {
    val name = "Zaw"
    println("Hello $name")
}
```

Output:

```
Hello Zaw
```

Instead of writing:

```kotlin
println("Hello " + name)
```

Kotlin makes it cleaner with `$`.

---

# 5️⃣ `${}` in String (Expression Insertion)

Use `${}` when:

* You want to do calculation
* You want to use expressions
* Variable name is not simple

---

## 🔹 Example 1: Math Expression

```kotlin
fun main() {
    val a = 5
    val b = 3
    println("Sum = ${a + b}")
}
```

Output:

```
Sum = 8
```

---

## 🔹 Example 2: Property Access

```kotlin
val name = "Zaw"
println("Length is ${name.length}")
```

---

## 🔹 When `$` Alone Works

✔ Works:

```kotlin
println("Hello $name")
```

❌ Not good for complex expression:

```kotlin
println("Sum = $a + $b")   // Wrong result
```

Correct way:

```kotlin
println("Sum = ${a + b}")
```

---

# 6️⃣ Escaping `$` Symbol

If you want to print actual `$`:

```kotlin
println("Price is \$10")
```

Output:

```
Price is $10
```

---

# 7️⃣ Multi-line String (Bonus)

Kotlin supports triple quotes:

```kotlin
val text = """
Hello
This is Kotlin
"""
println(text)
```

Useful for long text.

---

# 🧠 Summary

| Concept         | Meaning                |
| --------------- | ---------------------- |
| `print()`       | Print without new line |
| `println()`     | Print with new line    |
| `$variable`     | Insert variable        |
| `${expression}` | Insert expression      |
| `\"`            | Escape characters      |
| `\$`            | Print dollar sign      |

---

# 🎯 Very Important for Android

You will use string templates for:

* TextView updates
* Showing scores
* Displaying user info
* Logging messages

Example in Android:

```kotlin
textView.text = "Welcome $username"
```

---
 **Kotlin is case sensitive.**

That means:

```kotlin
val name = "John"
val Name = "Mike"
```

These are **two different variables**.

And:

```kotlin
fun printName() {}
fun PrintName() {}
```

Also **different functions**.

---

# 🔠 Case Rules You Should Know in Kotlin

There are official naming conventions (very important in Android projects 👇).

---

## 1️⃣ Variables & Functions → **camelCase**

Start with lowercase, capitalize next words.

```kotlin
val userName = "Zaw"
fun calculateTotalPrice() {}
```

✔ Correct
❌ `UserName` (wrong style for variable)
❌ `calculate_total_price` (not Kotlin style)

---

## 2️⃣ Classes → **PascalCase**

Start with uppercase.

```kotlin
class UserProfile
class NetworkMonitorService
```

✔ Correct
❌ `userProfile`
❌ `network_monitor_service`

---

## 3️⃣ Constants → **UPPER_SNAKE_CASE**

Used with `const val`.

```kotlin
const val MAX_RETRY_COUNT = 3
```

---

## 4️⃣ Enum Values → **UPPERCASE**

```kotlin
enum class NetworkState {
    CONNECTED,
    DISCONNECTED,
    UNKNOWN
}
```

---

## 5️⃣ Packages → **lowercase only**

```kotlin
package com.example.networkmonitor
```

Never use uppercase in package names.

---

# ⚠️ Why This Matters (Especially For You)

Since you're building an Android project with:

* MVVM
* ViewModel
* Compose
* Backend + AI

If you don’t follow naming conventions:

* Your code looks unprofessional
* Harder to collaborate
* Harder to read
* GitHub reviewers will notice

---

# 🧠 Quick Memory Trick

| Type     | Style            |
| -------- | ---------------- |
| Variable | camelCase        |
| Function | camelCase        |
| Class    | PascalCase       |
| Constant | UPPER_SNAKE_CASE |
| Package  | lowercase        |

---



