## Enum Classes in Kotlin

An **enum class** in Kotlin is used to represent a **fixed set of constant values**.

Think of it like:

> “These are the only possible values allowed.”

---

## 1️⃣ Basic Syntax

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Now you can use it like:

```kotlin
val dir: Direction = Direction.NORTH
```

You **cannot** assign anything else like `"UP"` or `10`. Only the defined constants are allowed.

---

## 2️⃣ Why Use Enum?

Without enum:

```kotlin
val status = "SUCCESS"  // risky (typo possible)
```

With enum:

```kotlin
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
```

Now it is **type-safe** ✅
No spelling mistakes. No invalid values.

---

## 3️⃣ Using Enum with `when`

Enum works perfectly with `when`:

```kotlin
fun checkStatus(status: Status) {
    when (status) {
        Status.SUCCESS -> println("Operation successful")
        Status.ERROR -> println("Something went wrong")
        Status.LOADING -> println("Please wait...")
    }
}
```

⚠ Notice: No `else` needed because all cases are covered.

---

## 4️⃣ Enum with Properties

Enums can have **properties and constructor**.

```kotlin
enum class Color(val hex: String) {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF")
}
```

Usage:

```kotlin
println(Color.RED.hex)  // #FF0000
```

Each enum constant is actually an **object**.

---

## 5️⃣ Enum with Functions

Enums can also have functions:

```kotlin
enum class Operation {
    ADD,
    SUBTRACT;

    fun apply(a: Int, b: Int): Int {
        return when (this) {
            ADD -> a + b
            SUBTRACT -> a - b
        }
    }
}
```

Usage:

```kotlin
val result = Operation.ADD.apply(5, 3)
println(result)  // 8
```

---

## 6️⃣ Special Built-in Enum Functions

Every enum has:

### ✔ `values()`

Returns all constants.

```kotlin
for (d in Direction.values()) {
    println(d)
}
```

### ✔ `valueOf()`

Convert string → enum.

```kotlin
val dir = Direction.valueOf("NORTH")
```

⚠ Must match exactly or it throws exception.

---

## 7️⃣ Enum vs Sealed Class

| Enum                | Sealed Class           |
| ------------------- | ---------------------- |
| Fixed constants     | Can have subclasses    |
| All instances known | More flexible          |
| Simple use cases    | Complex state modeling |

Use **enum** when:

* You have limited fixed options
* Like: days, status, roles, directions

Use **sealed class** when:

* Different types need different data
* More complex behavior

---

## 8️⃣ Real Android Example

In Android development, enums are used for:

* API status (SUCCESS, ERROR, LOADING)
* User roles (ADMIN, USER)
* Theme modes (LIGHT, DARK)

Example:

```kotlin
enum class ThemeMode {
    LIGHT,
    DARK
}
```

---

## 🎯 Summary

Enum class in Kotlin:

✔ Represents fixed constants
✔ Type-safe
✔ Works great with `when`
✔ Can have properties & functions
✔ Each constant is an object

---

