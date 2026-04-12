These are **Kotlin scope functions**—very important for clean, readable Android code. Let’s break them simply 👇

---

# 🔹 1. `.let { }`

### 👉 What it does:

* Executes a block of code on an object
* Uses **`it`** as the object inside the block
* Returns the **result of the block**

### ✅ Syntax:

```kotlin
object?.let {
    // use it here
}
```

### 💡 Example:

```kotlin
val name: String? = "John"

name?.let {
    println(it.length)
}
```

👉 Output: `4`

✔ If `name` is `null`, it won’t run → **null-safe**

---

### 📌 When to use `.let`

* Null checking
* Temporary object usage
* Avoid writing `if (x != null)`

---

# 🔹 2. `.map { }`

### 👉 What it does:

* Transforms each element in a collection
* Returns a **new list**

### 💡 Example:

```kotlin
val numbers = listOf(1, 2, 3)

val doubled = numbers.map {
    it * 2
}

println(doubled)
```

👉 Output:

```
[2, 4, 6]
```

✔ Original list is unchanged
✔ Creates a new list

---

### 📌 When to use `.map`

* Modify/transform data
* Convert one list into another

---

# 🔹 3. `it`

### 👉 What is `it`?

* Default name for a **single parameter** in lambdas

### 💡 Example:

```kotlin
listOf(1,2,3).map {
    it * 2
}
```

👉 `it` = current element

---

### ✨ Same example WITHOUT `it`:

```kotlin
listOf(1,2,3).map { number ->
    number * 2
}
```

✔ `it` is just a shortcut

---

# 🔥 Combine Example (Important for Android)

```kotlin
val user: String? = "Zaw"

val result = user?.let {
    it.uppercase()
}
```

👉 If `user != null` → convert to uppercase
👉 If `null` → result is null

---

# 🚀 Real Android Example

```kotlin
editText.text.toString().let {
    if (it.isNotEmpty()) {
        println(it)
    }
}
```

---

# 🧠 Quick Summary

| Function | Use                     | Returns         |
| -------- | ----------------------- | --------------- |
| `let`    | Work with object safely | Result of block |
| `map`    | Transform list          | New list        |
| `it`     | Default lambda variable | Just a name     |

---
Great—these 3 are **super important in Android Kotlin**. Once you get them, your code becomes much cleaner.

---

# 🔷 1. `.apply { }`

### 👉 What it does:

* Used to **configure an object**
* Uses **`this`**
* Returns the **object itself**

### 💡 Example:

```kotlin
val textView = TextView(this).apply {
    text = "Hello"
    textSize = 20f
}
```

✔ No need to repeat `textView.text = ...`
✔ Clean object setup

---

### 📌 When to use:

* Initializing UI components
* Setting multiple properties

---

# 🔷 2. `.also { }`

### 👉 What it does:

* Performs **extra actions (side effects)**
* Uses **`it`**
* Returns the **object itself**

### 💡 Example:

```kotlin
val numbers = mutableListOf(1, 2, 3)

numbers.also {
    println("Before adding: $it")
}.add(4)
```

👉 Output:

```
Before adding: [1, 2, 3]
```

---

### 📌 When to use:

* Logging
* Debugging
* Tracking data without modifying it

---

# 🔷 3. `.run { }`

### 👉 What it does:

* Executes block on object
* Uses **`this`**
* Returns **result of block**

### 💡 Example:

```kotlin
val result = "hello".run {
    uppercase()
}
println(result)
```

👉 Output:

```
HELLO
```

---

### 📌 When to use:

* When you want to **compute a result**
* Combine multiple operations

---

# 🔥 Android Real Example

### 🧩 Using `.apply`

```kotlin
val button = Button(this).apply {
    text = "Click Me"
    isEnabled = true
}
```

---

### 🧩 Using `.also`

```kotlin
val intent = Intent(this, SecondActivity::class.java).also {
    it.putExtra("name", "Zaw")
}
startActivity(intent)
```

---

### 🧩 Using `.run`

```kotlin
val length = editText.text.toString().run {
    trim().length
}
```

---

# 🧠 Difference (VERY IMPORTANT)

| Function | Object Ref | Returns | Use Case       |
| -------- | ---------- | ------- | -------------- |
| `apply`  | `this`     | Object  | Setup/config   |
| `also`   | `it`       | Object  | Side effects   |
| `run`    | `this`     | Result  | Compute result |

---

# ⚡ Easy Way to Remember

* **apply → "apply changes to object"**
* **also → "also do this (extra work)"**
* **run → "run and give result"**

---

# 🚀 Pro Tip (Interview Level)

```kotlin
val user = User().apply {
    name = "Zaw"
}.also {
    println("User created: $it")
}.run {
    name.uppercase()
}
```

👉 Flow:

1. `apply` → setup object
2. `also` → log it
3. `run` → compute result



