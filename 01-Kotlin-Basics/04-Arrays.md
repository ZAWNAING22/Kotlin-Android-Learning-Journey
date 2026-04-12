🔥 Arrays are very important foundation before Collections.

Let’s understand clearly step by step.

---

# 📌 What is an Array?

An **Array** is a container that stores:

👉 Multiple values
👉 Of the same type
👉 In a fixed size

Example:

Instead of writing:

```kotlin
val n1 = 10
val n2 = 20
val n3 = 30
```

We use:

```kotlin
val numbers = arrayOf(10, 20, 30)
```

---

# 1️⃣ Creating Arrays in Kotlin

## 🔹 Method 1: Using `arrayOf()`

```kotlin
val numbers = arrayOf(10, 20, 30, 40)
```

Kotlin automatically detects type → `Array<Int>`

---

## 🔹 Method 2: Specify Type

```kotlin
val numbers: Array<Int> = arrayOf(10, 20, 30)
```

---

## 🔹 Method 3: Empty Array with Size

```kotlin
val numbers = Array(5) { 0 }
```

This creates:

```
[0, 0, 0, 0, 0]
```

Size = 5
All values initialized to 0

---

# 2️⃣ Accessing Array Elements

Arrays use **index numbers**.

Index always starts from **0**.

```kotlin
val numbers = arrayOf(10, 20, 30)

println(numbers[0])   // 10
println(numbers[1])   // 20
println(numbers[2])   // 30
```

---

# 3️⃣ Changing Array Values

Arrays are mutable (elements can change).

```kotlin
val numbers = arrayOf(10, 20, 30)

numbers[1] = 50
println(numbers[1])   // 50
```

⚠ Even if array is `val`, elements can change.
`val` protects the reference, not internal data.

---

# 4️⃣ Array Size

```kotlin
val numbers = arrayOf(10, 20, 30)
println(numbers.size)   // 3
```

---

# 5️⃣ Looping Through Arrays

## 🔹 Using `for`

```kotlin
val numbers = arrayOf(10, 20, 30)

for (num in numbers) {
    println(num)
}
```

---

## 🔹 Using Index

```kotlin
for (i in numbers.indices) {
    println(numbers[i])
}
```

---

# 6️⃣ Special Primitive Arrays (Important)

Kotlin has optimized arrays for primitives:

| Type    | Array Type     |
| ------- | -------------- |
| Int     | `IntArray`     |
| Double  | `DoubleArray`  |
| Boolean | `BooleanArray` |

Example:

```kotlin
val numbers = intArrayOf(1, 2, 3)
```

Better performance than `Array<Int>`.

---

# 7️⃣ Real Example (Mini Program)

```kotlin
fun main() {
    val marks = arrayOf(80, 75, 90, 60)

    var total = 0

    for (mark in marks) {
        total += mark
    }

    val average = total / marks.size
    println("Average = $average")
}
```

---

# 🚨 Important Rules

1. Array size is fixed

   * You cannot add/remove elements
2. All elements must be same type
3. Index out of range → crash

```kotlin
println(numbers[5])  // ❌ Crash if size is 3
```

---

# 🧠 Array vs List (Important for Android)

In modern Kotlin & Android:

👉 We mostly use **List** instead of Array

Why?

* List is more flexible
* Can grow and shrink
* More functions available

Arrays are used when:

* Fixed size data
* Performance matters
* Java interoperability

---

# 🎯 Android Example

Imagine you have 3 image IDs:

```kotlin
val imageIds = arrayOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3
)
```

Used in:

* RecyclerView
* Image sliders
* Data storage

---

# 📌 Summary

| Concept     | Meaning             |
| ----------- | ------------------- |
| `arrayOf()` | Create array        |
| `[index]`   | Access element      |
| `.size`     | Get length          |
| `IntArray`  | Optimized int array |
| Fixed size  | Cannot grow         |

---

An **ArrayList** is a **dynamic array** in programming—most commonly used in Java/Kotlin (like in Android development).

---

## 🔹 Simple Definition

An **ArrayList** is a **resizable array** that can grow or shrink automatically as you add or remove elements.

---

## 🔹 Why not normal array?

Normal arrays:

* Fixed size ❌
* Hard to modify ❌

ArrayList:

* Dynamic size ✅
* Easy to add/remove elements ✅

---

## 🔹 Kotlin Example

```kotlin
val list = ArrayList<String>()

list.add("John")
list.add("Alice")
list.add("Bob")

println(list)   // [John, Alice, Bob]
```

---

## 🔹 Common Operations

### 1. Add element

```kotlin
list.add("David")
```

### 2. Access element

```kotlin
println(list[0])   // John
```

### 3. Update element

```kotlin
list[1] = "Emma"
```

### 4. Remove element

```kotlin
list.remove("Bob")
```

### 5. Size

```kotlin
println(list.size)
```

---

## 🔹 Loop through ArrayList

```kotlin
for (name in list) {
    println(name)
}
```

---

## 🔹 In Android (Very Important 🚀)

You use ArrayList in:

* **ListView**
* **RecyclerView**
* **Adapters**
* Storing data (like contacts in your SQLite app)

Example:

```kotlin
val contacts = ArrayList<String>()
contacts.add("Ali - 12345")
contacts.add("John - 67890")
```

---

## 🔹 Shortcut (Modern Kotlin Way)

Instead of `ArrayList`, Kotlin prefers:

```kotlin
val list = mutableListOf("A", "B", "C")
```

---

## 🔹 Summary

* ArrayList = dynamic array
* Stores multiple values
* Can grow/shrink
* Used everywhere in Android apps

---
*


