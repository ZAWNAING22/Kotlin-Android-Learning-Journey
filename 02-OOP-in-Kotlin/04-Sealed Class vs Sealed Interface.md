# 🔒 Sealed Classes & Sealed Interfaces in Kotlin

Sealed types are used when you want to **restrict inheritance**.

They are extremely important in:

* State management (Loading, Success, Error)
* API responses
* UI states (MVVM / Compose)
* When used with `when` expression

---

# 🔹 1️⃣ What is a Sealed Class?

A **sealed class** is a class that can only be inherited by a fixed set of subclasses.

👉 All subclasses must be defined in the **same file**.

---

## ✅ Basic Example

```kotlin
sealed class Result

class Success(val data: String) : Result()
class Error(val message: String) : Result()
object Loading : Result()
```

Now `Result` can only be:

* `Success`
* `Error`
* `Loading`

Nothing else.

---

# 🔥 Why is This Powerful?

When you use `when`, Kotlin knows all possible types.

```kotlin
fun handle(result: Result) {
    when (result) {
        is Success -> println(result.data)
        is Error -> println(result.message)
        Loading -> println("Loading...")
    }
}
```

Notice:
❌ No `else` needed
Because Kotlin knows all possible subclasses.

This makes your code safer.

---

# 🔹 2️⃣ Real Android Example (Very Important)

```kotlin
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<String>) : UiState()
    data class Error(val message: String) : UiState()
}
```

Used in ViewModel:

```kotlin
when (state) {
    is UiState.Loading -> showLoading()
    is UiState.Success -> showData(state.data)
    is UiState.Error -> showError(state.message)
}
```

This is extremely common in modern Android apps.

---

# 🔹 3️⃣ Sealed Interface

A **sealed interface** works the same way as sealed class,
but it's an interface instead of a class.

---

## ✅ Example

```kotlin
sealed interface Payment

class Cash : Payment
class Card : Payment
class Online(val provider: String) : Payment
```

Used with `when`:

```kotlin
fun process(payment: Payment) {
    when (payment) {
        is Cash -> println("Cash payment")
        is Card -> println("Card payment")
        is Online -> println("Online via ${payment.provider}")
    }
}
```

Again, no `else` needed.

---

# 🔥 Sealed Class vs Sealed Interface

| Sealed Class                       | Sealed Interface                  |
| ---------------------------------- | --------------------------------- |
| Can hold state                     | Cannot hold state directly        |
| Can have constructor               | No constructor                    |
| Only one class inheritance allowed | Can implement multiple interfaces |
| Used as base type                  | Used for capability modeling      |

---

# 🔥 Sealed vs Enum (Important Difference)

| Enum                                          | Sealed                                      |
| --------------------------------------------- | ------------------------------------------- |
| Fixed constants only                          | Can hold different data types               |
| Cannot have different parameters per constant | Each subclass can have different properties |
| Simple cases                                  | Complex states                              |

---

## Enum Example

```kotlin
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}
```

---

## Sealed Equivalent (More Powerful)

```kotlin
sealed class Direction {
    object North : Direction()
    object South : Direction()
    data class Custom(val degree: Int) : Direction()
}
```

Now you can even pass custom values.

---

# 🎯 When to Use Sealed?

Use sealed types when:

✅ You know all possible states
✅ States should not be extended outside
✅ You want safe `when` expressions
✅ You're building UI state or API response models

---

# 🎯 Why Sealed is Very Important in Android?

Modern Android (especially Jetpack Compose + MVVM) uses sealed classes heavily for:

* UI State
* Network result handling
* Navigation state
* Error handling

Kotlin was created by **JetBrains** and officially supported for Android by **Google**, and sealed classes are one of the key features that made Kotlin powerful for Android architecture.

---

# 🚀 Simple Mental Model

Think of sealed class like:

> "These are the ONLY possible types. Nothing else allowed."

---

# 📌 Final Summary

## Sealed Class

* Restricted inheritance
* All subclasses in same file
* Great with `when`
* Can hold state & constructors

## Sealed Interface

* Same restriction idea
* Works like interface
* Can be implemented by multiple classes

---


