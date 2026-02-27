# 🔐 Visibility Modifiers in Kotlin

Visibility modifiers control **where your code can be accessed from**.

Kotlin has **4 visibility modifiers**:

1. `public`
2. `private`
3. `protected`
4. `internal`

---

# 1️⃣ `public` (Default)

If you don’t write anything → it is **public by default**.

```kotlin
class User {
    fun greet() {
        println("Hello")
    }
}
```

✔ Accessible from everywhere
✔ Default visibility

You can also write it explicitly:

```kotlin
public class User
```

---

# 2️⃣ `private`

`private` means:

> Accessible only inside the same class or file.

### 🔹 Inside a class

```kotlin
class User {
    private val password = "1234"

    fun showPassword() {
        println(password)
    }
}
```

You cannot access `password` from outside the class ❌

---

### 🔹 Top-level `private`

```kotlin
private fun helper() {
    println("Helper function")
}
```

Accessible only inside that file.

---

# 3️⃣ `protected`

`protected` means:

> Accessible inside the class and its subclasses.

```kotlin
open class Animal {
    protected fun makeSound() {
        println("Some sound")
    }
}

class Dog : Animal() {
    fun bark() {
        makeSound()  // allowed
    }
}
```

But from outside:

```kotlin
val dog = Dog()
dog.makeSound()  ❌ Not allowed
```

⚠ `protected` is only for class members (not top-level).

---

# 4️⃣ `internal`

`internal` means:

> Accessible anywhere inside the same module.

A **module** = a project / Gradle module.

```kotlin
internal class Helper
```

✔ Accessible inside the same project
❌ Not accessible from another module/library

---

# 📊 Summary Table

| Modifier  | Same Class | Subclass | Same Module | Everywhere |
| --------- | ---------- | -------- | ----------- | ---------- |
| public    | ✅          | ✅        | ✅           | ✅          |
| private   | ✅          | ❌        | ❌           | ❌          |
| protected | ✅          | ✅        | ❌           | ❌          |
| internal  | ✅          | ✅        | ✅           | ❌          |

---

# 🧠 Real Android Usage

In Android development:

### ✔ `private`

Used for:

* View binding
* Helper functions
* Internal logic

```kotlin
private lateinit var binding: ActivityMainBinding
```

---

### ✔ `internal`

Used when:

* Creating library modules
* Hiding implementation details

---

### ✔ `protected`

Used in:

* Base Activity classes
* Custom View inheritance

---

# 🔥 Important Rule

Kotlin follows:

> "Restrict as much as possible."

Good practice:

* Make everything `private` by default.
* Only increase visibility when needed.

---

# ⚡ Example Combined

```kotlin
internal open class BaseActivity {

    private fun setupUI() {}

    protected fun loadData() {}

    public fun start() {}
}
```

---

# 🎯 Final Understanding

Visibility modifiers help with:

✔ Encapsulation
✔ Security
✔ Clean architecture
✔ Preventing misuse

---


