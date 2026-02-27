🔥 This is **one of the most important Kotlin topics for Android development**.

In real apps:

> You download JSON from an API → convert to objects → transform → filter → group → display in UI.

You will really spend **50% of your time transforming lists**.

Let’s go step by step.

---

# 🧠 1️⃣ Standard Library Collection Functions

Assume we have:

```kotlin
data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val city: String
)

val users = listOf(
    User(1, "Ali", 22, "Istanbul"),
    User(2, "Veli", 17, "Ankara"),
    User(3, "Ayse", 25, "Istanbul"),
    User(4, "Mehmet", 30, "Izmir")
)
```

---

# 🔹 filter → Select Some Items

Keeps elements that match a condition.

```kotlin
val adults = users.filter { it.age >= 18 }
```

Result:

* Ali
* Ayse
* Mehmet

📌 Used when:

* Show only active users
* Show only paid orders
* Filter by search query

---

# 🔹 map → Transform Items

Changes each element into something else.

```kotlin
val names = users.map { it.name }
```

Result:

```
["Ali", "Veli", "Ayse", "Mehmet"]
```

📌 Used when:

* Convert API model → UI model
* Extract only specific fields
* Format data

---

# 🔹 flatMap → Flatten Nested Lists

Used when each item returns a list.

Example:

```kotlin
data class Group(val members: List<User>)

val groups = listOf(
    Group(listOf(users[0], users[1])),
    Group(listOf(users[2]))
)

val allMembers = groups.flatMap { it.members }
```

Result:
All users in one single list.

📌 Used when:

* API returns nested lists
* Categories → Products → want one product list

---

# 🔹 associateBy → Convert List → Map

Convert list into a map using a key.

```kotlin
val userMap = users.associateBy { it.id }
```

Result:

```
Map<Int, User>
```

Now you can:

```kotlin
val user = userMap[1]
```

📌 Used when:

* Fast lookup by ID
* Caching data

---

# 🔹 groupBy → Group Items

Group items by condition.

```kotlin
val groupedByCity = users.groupBy { it.city }
```

Result:

```
Istanbul -> [Ali, Ayse]
Ankara   -> [Veli]
Izmir    -> [Mehmet]
```

📌 Used when:

* Group by category
* Group chat messages by date
* Group products by type

---

# 🔹 fold → Accumulate Values

General accumulation function.

```kotlin
val totalAge = users.fold(0) { total, user ->
    total + user.age
}
```

Result:
Sum of all ages.

`0` = initial value.

---

# 🔹 reduce → Similar to fold (but no initial value)

```kotlin
val totalAge = users.map { it.age }
    .reduce { acc, age -> acc + age }
```

⚠️ Reduce crashes if list is empty.
Fold is safer.

---

# 🧠 Real Android Example

Imagine API returns products.

You might do:

```kotlin
val uiModels = products
    .filter { it.inStock }
    .map { product ->
        ProductUI(
            name = product.name,
            priceText = "$${product.price}"
        )
    }
```

This is **real-world Android code**.

---

# ⚡ 2️⃣ Sequences (For Large Data Sets)

By default, Kotlin collections are:

> Eager (execute immediately)

Example:

```kotlin
users
    .filter { it.age > 18 }
    .map { it.name }
```

Step 1: filter creates new list
Step 2: map creates another new list

For very large lists → waste memory.

---

## 🔥 Sequence = Lazy Processing

Sequence processes elements one by one.

```kotlin
val names = users
    .asSequence()
    .filter { it.age > 18 }
    .map { it.name }
    .toList()
```

Now:

* No intermediate lists
* Processes one element at a time

---

## 🔍 How It Works

Normal List:

```
filter ALL → create list
map ALL → create list
```

Sequence:

```
filter 1 → map 1
filter 2 → map 2
filter 3 → map 3
```

One by one.

---

## 📌 When To Use Sequence?

Use when:

* Large datasets (10k+ items)
* Multiple chained operations
* Performance matters

Do NOT use when:

* Small lists
* Simple operations

Because Sequence has small overhead.

---

# 🔥 Example With Large Data

```kotlin
val result = (1..1_000_000)
    .asSequence()
    .filter { it % 2 == 0 }
    .map { it * 2 }
    .take(5)
    .toList()
```

Sequence stops after 5 items.

Normal list would process 1 million items first 😬

---

# 🧠 Android Use Case

* Paging large API results
* Filtering search results
* Processing database records
* Background data transformations

---

# 🏆 Most Important Functions (Memorize These)

You will use daily:

* filter
* map
* groupBy
* associateBy
* fold
* flatMap

---

# 🎯 Summary Table

| Function    | Purpose                       |
| ----------- | ----------------------------- |
| filter      | Remove items                  |
| map         | Transform items               |
| flatMap     | Flatten nested lists          |
| associateBy | List → Map                    |
| groupBy     | Group items                   |
| fold        | Accumulate with initial value |
| reduce      | Accumulate without initial    |
| Sequence    | Lazy + memory efficient       |

---

