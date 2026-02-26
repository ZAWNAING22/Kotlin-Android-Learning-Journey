## 📦 Sets and Maps in Kotlin

Both **Set** and **Map** are part of Kotlin **Collections**.

They are used to store multiple values — but in different ways.

---

# 🔷 1️⃣ Set in Kotlin

A **Set** stores **unique values only**.

👉 No duplicates allowed.

---

## ✅ Creating a Set

```kotlin
val numbers = setOf(1, 2, 3, 3, 4)
println(numbers)
```

Output:

```
[1, 2, 3, 4]
```

Even though `3` was added twice → it appears only once.

---

## 🔹 Types of Sets

### 1. Immutable Set (Read-only)

```kotlin
val names = setOf("Ali", "John", "Ali")
```

You cannot add or remove items.

---

### 2. Mutable Set

```kotlin
val names = mutableSetOf("Ali", "John")
names.add("Sara")
names.remove("Ali")
println(names)
```

---

## 🔹 Common Set Operations

```kotlin
val set1 = setOf(1, 2, 3)
val set2 = setOf(3, 4, 5)

println(set1 union set2)        // combine
println(set1 intersect set2)    // common values
println(set1 subtract set2)     // remove matching
```

---

## 🔹 When to Use Set in Android?

* Storing unique user IDs
* Prevent duplicate entries
* Tracking selected items
* Tag systems

Example:

```kotlin
val selectedIds = mutableSetOf<Int>()
```

---

# 🔷 2️⃣ Map in Kotlin

A **Map** stores data in **key-value pairs**.

👉 Each key is unique
👉 Values can be duplicated

---

## ✅ Creating a Map

```kotlin
val user = mapOf(
    "name" to "Ali",
    "age" to 25,
    "city" to "Istanbul"
)

println(user["name"])
```

Output:

```
Ali
```

---

## 🔹 Mutable Map

```kotlin
val user = mutableMapOf<String, Int>()

user["Ali"] = 25
user["John"] = 30

println(user)
```

---

## 🔹 Loop Through Map

```kotlin
for ((key, value) in user) {
    println("$key -> $value")
}
```

---

## 🔹 Important Map Functions

```kotlin
user.containsKey("Ali")
user.containsValue(25)
user.remove("Ali")
user.keys
user.values
```

---

# 🔷 HashMap vs LinkedHashMap (Advanced)

By default:

* `mapOf()` → returns **LinkedHashMap**
* Maintains insertion order

If you use:

```kotlin
val map = hashMapOf("a" to 1, "b" to 2)
```

* Order not guaranteed

---

# 🧠 Difference Between Set and Map

| Feature   | Set           | Map                |
| --------- | ------------- | ------------------ |
| Stores    | Values only   | Key + Value        |
| Duplicate | ❌ Not allowed | ❌ Keys not allowed |
| Access    | By value      | By key             |

---

# 🚀 Real Android Example

### Example: Count word frequency

```kotlin
val words = listOf("apple", "banana", "apple", "orange")

val frequency = mutableMapOf<String, Int>()

for (word in words) {
    frequency[word] = (frequency[word] ?: 0) + 1
}

println(frequency)
```

Output:

```
{apple=2, banana=1, orange=1}
```

---

# 🎯 When To Use What?

Use **Set** when:

* You need uniqueness
* Order not important
* Fast lookup

Use **Map** when:

* You need to associate a value with a key
* Dictionary-like structure
* Storing structured data

---



What do you want?
