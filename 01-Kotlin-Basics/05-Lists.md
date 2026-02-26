 **Lists** — this is VERY important for Kotlin and Android.

In modern Kotlin development, we use **List much more than Array**.

---

# 📌 What is a List?

A **List** is a collection that:

👉 Stores multiple values
👉 In order (index-based)
👉 Can be immutable or mutable
👉 Can grow or shrink (if mutable)

---

# 1️⃣ Types of Lists in Kotlin

There are **two main types**:

| Type          | Can Change?      |
| ------------- | ---------------- |
| `List`        | ❌ No (Read-only) |
| `MutableList` | ✅ Yes            |

---

# 2️⃣ Immutable List (Read-Only)

Created using `listOf()`

```kotlin
val numbers = listOf(10, 20, 30)
```

You can:

✔ Read values
✔ Access by index
❌ Cannot add or remove

---

## 🔹 Access Elements

```kotlin
println(numbers[0])   // 10
println(numbers.size) // 3
```

---

## ❌ This will cause error

```kotlin
numbers.add(40)   // Not allowed
```

Because it's read-only.

---

# 3️⃣ Mutable List (Changeable)

Created using `mutableListOf()`

```kotlin
val numbers = mutableListOf(10, 20, 30)
```

Now you can:

✔ Add
✔ Remove
✔ Update

---

## 🔹 Add Element

```kotlin
numbers.add(40)
println(numbers)  // [10, 20, 30, 40]
```

---

## 🔹 Remove Element

```kotlin
numbers.remove(20)
println(numbers)  // [10, 30, 40]
```

---

## 🔹 Update Element

```kotlin
numbers[0] = 100
println(numbers)  // [100, 30, 40]
```

---

# 4️⃣ Looping Through List

## 🔹 For-each loop

```kotlin
for (num in numbers) {
    println(num)
}
```

---

## 🔹 With index

```kotlin
for (i in numbers.indices) {
    println("Index $i = ${numbers[i]}")
}
```

---

# 5️⃣ Useful List Functions (Very Important)

### 🔹 `contains()`

```kotlin
println(numbers.contains(30))  // true
```

---

### 🔹 `isEmpty()`

```kotlin
println(numbers.isEmpty())
```

---

### 🔹 `sorted()`

```kotlin
val sortedList = numbers.sorted()
```

---

### 🔹 `filter()`

```kotlin
val evenNumbers = numbers.filter { it % 2 == 0 }
```

This is called **lambda expression** (we’ll explain later).

---

# 6️⃣ List Type Declaration

```kotlin
val names: List<String> = listOf("Ali", "John", "Zaw")
```

For mutable:

```kotlin
val names: MutableList<String> = mutableListOf()
```

---

# 7️⃣ Real Android Example 🔥

Lists are used in:

* RecyclerView
* ListView
* Showing products
* Chat messages
* Notifications

Example:

```kotlin
val messages = mutableListOf<String>()

fun addMessage(msg: String) {
    messages.add(msg)
}
```

---

# 🧠 Array vs List (Very Important)

| Array           | List                    |
| --------------- | ----------------------- |
| Fixed size      | Can grow (mutable)      |
| Basic           | More powerful           |
| Less functions  | Many built-in functions |
| Rare in Android | Very common in Android  |

👉 In Android development → **Use List 90% of the time**

---

# 📌 Summary

| Function          | Meaning         |
| ----------------- | --------------- |
| `listOf()`        | Immutable list  |
| `mutableListOf()` | Mutable list    |
| `.add()`          | Add element     |
| `.remove()`       | Remove element  |
| `.size`           | Get length      |
| `.filter {}`      | Filter elements |

---



Tell me what you want 💪
