## 🔁 Loops in Kotlin

Loops are used to **repeat a block of code multiple times**.
In Kotlin, you mainly use:

1. `for` loop
2. `while` loop
3. `do...while` loop

---

# 1️⃣ `for` Loop (Most Common in Kotlin)

Used when you know **how many times** you want to repeat something.

### ✅ Basic Example

```kotlin
for (i in 1..5) {
    println(i)
}
```

**Output:**

```
1
2
3
4
5
```

### 🔎 Explanation

* `1..5` → range from 1 to 5 (inclusive)
* `i` → loop variable
* `in` → used to iterate over a range or collection

---

## 🔹 Loop with `until` (Excludes last number)

```kotlin
for (i in 1 until 5) {
    println(i)
}
```

Output:

```
1
2
3
4
```

👉 `until` excludes the last number.

---

## 🔹 Step in Loop

```kotlin
for (i in 1..10 step 2) {
    println(i)
}
```

Output:

```
1
3
5
7
9
```

---

## 🔹 Downward Loop

```kotlin
for (i in 10 downTo 1) {
    println(i)
}
```

---

# 2️⃣ Loop Through Collections

Very important in Android development.

```kotlin
val names = listOf("Ali", "John", "Sara")

for (name in names) {
    println(name)
}
```

---

## 🔹 Loop with Index

```kotlin
for (i in names.indices) {
    println("Index: $i Value: ${names[i]}")
}
```

OR better way:

```kotlin
for ((index, value) in names.withIndex()) {
    println("Index: $index Value: $value")
}
```

---

# 3️⃣ `while` Loop

Used when you **don’t know how many times** the loop should run.

```kotlin
var i = 1

while (i <= 5) {
    println(i)
    i++
}
```

👉 Condition is checked **before** execution.

---

# 4️⃣ `do...while` Loop

Executes at least **one time**, even if condition is false.

```kotlin
var i = 1

do {
    println(i)
    i++
} while (i <= 5)
```

👉 Condition checked **after** execution.

---

# 5️⃣ `break` and `continue`

### 🔹 `break`

Stops the loop completely.

```kotlin
for (i in 1..10) {
    if (i == 5) break
    println(i)
}
```

---

### 🔹 `continue`

Skips current iteration.

```kotlin
for (i in 1..5) {
    if (i == 3) continue
    println(i)
}
```

---

# 6️⃣ Labeled Break (Advanced)

Used in nested loops.

```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) break@outer
        println("i=$i j=$j")
    }
}
```

---

# 🚀 Where Loops Are Used in Android

In Android development, loops are used for:

* Showing list data (RecyclerView items)
* Processing API response lists
* Iterating database results
* Running background tasks
* Form validation checks

Example:

```kotlin
for (user in usersList) {
    if (user.isActive) {
        showUser(user)
    }
}
```

---

# 🧠 Quick Summary

| Loop Type  | When to Use                                 |
| ---------- | ------------------------------------------- |
| `for`      | When you know range or iterating collection |
| `while`    | When condition-based repetition             |
| `do-while` | Must run at least once                      |

---


What do you want next?
