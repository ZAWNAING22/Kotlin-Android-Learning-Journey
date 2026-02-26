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

