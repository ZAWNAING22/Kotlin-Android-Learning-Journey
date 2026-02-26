

# 1️⃣ Arithmetic Operators (Math Operators)

Used for mathematical calculations.

| Operator | Meaning             | Example |
| -------- | ------------------- | ------- |
| `+`      | Addition            | 5 + 3   |
| `-`      | Subtraction         | 5 - 3   |
| `*`      | Multiplication      | 5 * 3   |
| `/`      | Division            | 10 / 2  |
| `%`      | Modulus (Remainder) | 10 % 3  |

---

## 🔹 1. Addition `+`

```kotlin
val a = 5
val b = 3
val result = a + b   // 8
```

---

## 🔹 2. Subtraction `-`

```kotlin
val result = 10 - 4   // 6
```

---

## 🔹 3. Multiplication `*`

```kotlin
val result = 6 * 2   // 12
```

---

## 🔹 4. Division `/`

```kotlin
val result = 10 / 2   // 5
```

⚠ Important:

If both numbers are `Int`, result is `Int`.

```kotlin
val result = 5 / 2   // 2 (not 2.5)
```

For decimal:

```kotlin
val result = 5.0 / 2   // 2.5
```

---

## 🔹 5. Modulus `%` (Remainder)

```kotlin
val result = 10 % 3   // 1
```

Used for:

* Checking even/odd numbers
* Loop patterns

Example:

```kotlin
val number = 4
if (number % 2 == 0) {
    println("Even")
}
```

---

## 🔹 Increment & Decrement

| Operator | Meaning       |
| -------- | ------------- |
| `++`     | Increase by 1 |
| `--`     | Decrease by 1 |

```kotlin
var count = 5
count++   // 6
count--   // 5
```

Used a lot in loops.

---

# 2️⃣ Comparison Operators

Used to compare values.

They return **Boolean** (`true` or `false`).

| Operator | Meaning               |
| -------- | --------------------- |
| `==`     | Equal                 |
| `!=`     | Not equal             |
| `>`      | Greater than          |
| `<`      | Less than             |
| `>=`     | Greater than or equal |
| `<=`     | Less than or equal    |

---

## 🔹 Example

```kotlin
val a = 10
val b = 5

println(a > b)   // true
println(a == b)  // false
println(a != b)  // true
```

---

### 🔥 Important in Kotlin

`==` checks **value equality** (not reference like Java).

Example:

```kotlin
val name1 = "Zaw"
val name2 = "Zaw"

println(name1 == name2)   // true
```

---

# 3️⃣ Logical Operators

Used to combine multiple conditions.

| Operator | Meaning |   |    |
| -------- | ------- | - | -- |
| `&&`     | AND     |   |    |
| `        |         | ` | OR |
| `!`      | NOT     |   |    |

---

## 🔹 1. AND `&&`

Returns `true` only if BOTH conditions are true.

```kotlin
val age = 25
val hasID = true

if (age > 18 && hasID) {
    println("Allowed")
}
```

✔ true && true → true
❌ true && false → false

---

## 🔹 2. OR `||`

Returns `true` if at least one condition is true.

```kotlin
val isAdmin = false
val isManager = true

if (isAdmin || isManager) {
    println("Access granted")
}
```

✔ true || false → true
❌ false || false → false

---

## 🔹 3. NOT `!`

Reverses Boolean value.

```kotlin
val isLoggedIn = false

if (!isLoggedIn) {
    println("Please login")
}
```

`!false` → true
`!true` → false

---

# 🧠 Real Android Example

```kotlin
val email = "user@gmail.com"
val password = "123456"

if (email.isNotEmpty() && password.length >= 6) {
    println("Login successful")
}
```

You used:

* Comparison (`>=`)
* Logical AND (`&&`)
* Boolean condition

This is exactly how login validation works in Android apps.

---

# 💡 Summary

### Arithmetic → Math

`+ - * / %`

### Comparison → Compare values

`== != > < >= <=`

### Logical → Combine conditions

`&& || !`

---

# 📌 Assignment Operators in Kotlin

Assignment operators are used to **assign values to variables**.

---

# 1️⃣ Basic Assignment Operator

## 🔹 `=`

This assigns a value to a variable.

```kotlin
val name = "Zaw"
var age = 25
```

Here:

* `name` is assigned `"Zaw"`
* `age` is assigned `25`

---

# 2️⃣ Compound Assignment Operators

These are shortcuts that combine:

👉 arithmetic operation
👉 and assignment

Instead of writing:

```kotlin
x = x + 5
```

You can write:

```kotlin
x += 5
```

Much cleaner ✅

---

## 🔹 1. `+=` (Add and Assign)

```kotlin
var x = 10
x += 5   // x = x + 5
println(x)  // 15
```

Also works with strings:

```kotlin
var message = "Hello"
message += " World"
println(message)  // Hello World
```

---

## 🔹 2. `-=` (Subtract and Assign)

```kotlin
var x = 10
x -= 3   // x = x - 3
println(x)  // 7
```

---

## 🔹 3. `*=` (Multiply and Assign)

```kotlin
var x = 4
x *= 2   // x = x * 2
println(x)  // 8
```

---

## 🔹 4. `/=` (Divide and Assign)

```kotlin
var x = 20
x /= 4   // x = x / 4
println(x)  // 5
```

⚠ Same rule applies:
If both numbers are Int → result is Int.

---

## 🔹 5. `%=` (Modulus and Assign)

```kotlin
var x = 10
x %= 3   // x = x % 3
println(x)  // 1
```

---

# 🚨 Important Rule

Compound assignment works **only with `var`**, not `val`.

❌ This will cause error:

```kotlin
val number = 10
number += 5   // Error
```

Because `val` cannot be changed.

---

# 🔥 Real Android Example

Counter in app:

```kotlin
var likes = 0

fun onLikeButtonClicked() {
    likes += 1
}
```

Cart total price:

```kotlin
var totalPrice = 0.0

fun addItem(price: Double) {
    totalPrice += price
}
```

---

# 🧠 Quick Summary

| Operator | Meaning             |
| -------- | ------------------- |
| `=`      | Assign              |
| `+=`     | Add and assign      |
| `-=`     | Subtract and assign |
| `*=`     | Multiply and assign |
| `/=`     | Divide and assign   |
| `%=`     | Modulus and assign  |

---

# 🎯 Best Practice Tip

In professional Kotlin:

* Use `val` whenever possible
* Use `var` only when state must change
* Compound operators make code cleaner and more readable



