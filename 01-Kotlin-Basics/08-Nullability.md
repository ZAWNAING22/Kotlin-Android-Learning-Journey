## 🔐 Nullability in Kotlin

Nullability is one of the **most important features in Kotlin**.
It helps prevent **NullPointerException (NPE)** — a very common crash in languages like Java.

---

# 1️⃣ What is Null?

`null` means **no value** or **empty reference**.

Example in Java:

```java
String name = null;
System.out.println(name.length()); // ❌ Crash (NullPointerException)
```

Kotlin was designed to **reduce this problem**.

---

# 2️⃣ Nullable vs Non-Nullable Types

In Kotlin, variables are **non-nullable by default**.

### ✅ Non-nullable (Default)

```kotlin
var name: String = "John"
```

You CANNOT assign null:

```kotlin
name = null  // ❌ Error
```

---

### ✅ Nullable Type (`?`)

If you want a variable to allow null, you must add `?`

```kotlin
var name: String? = "John"
name = null   // ✅ Allowed
```

👉 `String?` means:

> This variable can hold either a String OR null.

---

# 3️⃣ Why Kotlin Forces This?

Because this is dangerous:

```kotlin
var name: String? = null
println(name.length)  // ❌ Error
```

Kotlin stops you at **compile time** instead of crashing at runtime.

---

# 4️⃣ Safe Call Operator `?.`

Used to safely call a method on a nullable variable.

```kotlin
var name: String? = null
println(name?.length)
```

If `name` is:

* not null → returns length
* null → returns null (no crash)

---

# 5️⃣ Elvis Operator `?:`

Used to provide a default value if null.

```kotlin
var name: String? = null
val length = name?.length ?: 0
println(length)   // 0
```

👉 Meaning:

> If left side is null, use right side.

---

# 6️⃣ Not-Null Assertion `!!`

Forces Kotlin to treat value as non-null.

```kotlin
var name: String? = null
println(name!!.length)  // 💥 Crash
```

⚠️ If value is null → app crashes.

Use this **only if you are 100% sure** value is not null.

---

# 7️⃣ Safe Cast `as?`

```kotlin
val obj: Any = "Hello"
val str: String? = obj as? String
```

If cast fails → returns null instead of crashing.

---

# 8️⃣ `let` with Nullable

Very common pattern:

```kotlin
var name: String? = "John"

name?.let {
    println("Length is ${it.length}")
}
```

Code inside `let` runs **only if value is NOT null**.

---

# 9️⃣ Example in Android Development

In Android, many things can be null:

```kotlin
val text = intent.getStringExtra("username")
```

`getStringExtra()` returns `String?`

So you must handle it:

```kotlin
val username = text ?: "Guest"
```

---

# 🔥 Summary Table

| Operator | Meaning                    |
| -------- | -------------------------- |
| `?`      | Makes type nullable        |
| `?.`     | Safe call                  |
| `?:`     | Elvis (default value)      |
| `!!`     | Force non-null (dangerous) |
| `as?`    | Safe cast                  |

---

# 🎯 Why Nullability is Important?

Without null safety → many crashes.
With Kotlin → most null crashes are prevented at compile time.

This is one reason why Kotlin became official Android language at **Google** and works closely with **JetBrains** (creator of Kotlin).

---


Just tell me 👍
