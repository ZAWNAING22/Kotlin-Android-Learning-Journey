# 🧩 Generics in Kotlin

**Generics** allow you to write **flexible and reusable code** by using **type parameters**.

Instead of fixing a type (like `Int` or `String`), you use a **placeholder type**.

---

# 1️⃣ Why Generics?

Without generics:

```kotlin
fun printInt(value: Int) {
    println(value)
}
```

This only works for `Int`.

With generics:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

Now it works for:

```kotlin
printValue(10)
printValue("Hello")
printValue(true)
```

`T` = Type parameter
It can be anything.

---

# 2️⃣ Generic Class

```kotlin
class Box<T>(val item: T)
```

Usage:

```kotlin
val intBox = Box(10)
val stringBox = Box("Kotlin")
```

The same class works for different types.

---

# 3️⃣ Real Kotlin Example (Collections)

Kotlin collections use generics:

```kotlin
val numbers: List<Int> = listOf(1, 2, 3)
val names: List<String> = listOf("Ali", "Zaw")
```

`List<T>` is generic.

---

# 4️⃣ Multiple Type Parameters

```kotlin
class PairBox<A, B>(val first: A, val second: B)
```

Usage:

```kotlin
val pair = PairBox("Age", 25)
```

---

# 5️⃣ Generic Constraints (Upper Bound)

You can restrict the type.

```kotlin
fun <T : Number> add(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}
```

Now only subclasses of `Number` are allowed:

```kotlin
add(5, 10)      // OK
add(5.5, 2.2)   // OK
add("Hi", "Bye") ❌ Not allowed
```

---

# 6️⃣ `out` (Covariance)

Used when you only **produce** values.

```kotlin
class Producer<out T>(val value: T)
```

Meaning:

* You can return `T`
* But cannot accept `T` as parameter

This is used in:

```kotlin
List<out T>
```

👉 Think: "out = output"

---

# 7️⃣ `in` (Contravariance)

Used when you only **consume** values.

```kotlin
class Consumer<in T> {
    fun accept(value: T) {}
}
```

👉 Think: "in = input"

---

# 8️⃣ Star Projection `*`

Used when type is unknown.

```kotlin
fun printList(list: List<*>) {
    for (item in list) {
        println(item)
    }
}
```

---

# 9️⃣ Reified Generics (Advanced 🔥)

Normally, type info is erased at runtime (type erasure).

But with `inline` + `reified`:

```kotlin
inline fun <reified T> checkType(value: Any) {
    if (value is T) {
        println("Matches type")
    }
}
```

Usage:

```kotlin
checkType<String>("Hello")
```

Very useful in Android when checking types.

---

# 🔟 Real Android Example

Generic API response wrapper:

```kotlin
data class ApiResponse<T>(
    val data: T?,
    val error: String?
)
```

Usage:

```kotlin
val response: ApiResponse<User>
```

Reusable for any model.

---

# 📊 Summary

| Concept      | Meaning                   |
| ------------ | ------------------------- |
| `<T>`        | Type parameter            |
| `<T : Type>` | Type constraint           |
| `out`        | Producing (covariant)     |
| `in`         | Consuming (contravariant) |
| `*`          | Unknown type              |
| `reified`    | Keep type at runtime      |

---

# 🎯 When to Use Generics?

✔ Collections
✔ Repository pattern
✔ API responses
✔ Reusable utility classes
✔ Data wrappers

---

