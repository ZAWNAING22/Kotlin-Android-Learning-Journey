# 🟣 Singletons in Kotlin (`object`)

In Kotlin, a **Singleton** means:

> Only **one instance** of a class exists in the entire app.

Kotlin makes this very easy using the `object` keyword.

---

# 1️⃣ Basic Singleton (`object`)

```kotlin
object DatabaseManager {
    fun connect() {
        println("Connected to database")
    }
}
```

Usage:

```kotlin
DatabaseManager.connect()
```

✅ You don’t create it with `new`
✅ You don’t create multiple objects
✅ Only one instance exists automatically

---

# 2️⃣ Why Singleton?

Use Singleton when you need:

* One shared resource
* Global configuration
* Logger
* Database helper
* Network client

---

# 3️⃣ Real Android Example

In Android development:

```kotlin
object SessionManager {
    var currentUser: String? = null

    fun login(user: String) {
        currentUser = user
    }
}
```

You can access it anywhere:

```kotlin
SessionManager.login("Zaw")
println(SessionManager.currentUser)
```

Very useful for:

* User session
* SharedPreferences wrapper
* API client

---

# 4️⃣ Object with Properties

```kotlin
object AppConfig {
    val appName = "MyApp"
    const val VERSION = "1.0"
}
```

Access like:

```kotlin
println(AppConfig.appName)
```

---

# 5️⃣ Singleton with Initialization Block

```kotlin
object Logger {
    init {
        println("Logger initialized")
    }

    fun log(message: String) {
        println(message)
    }
}
```

⚠ `init` runs only once (first time used).

---

# 6️⃣ Companion Object (Singleton inside class)

Sometimes you want singleton behavior inside a class.

```kotlin
class User {
    companion object {
        fun createGuest(): User {
            return User()
        }
    }
}
```

Usage:

```kotlin
val guest = User.createGuest()
```

🔹 `companion object` behaves like static in Java.

---

# 7️⃣ Object Expression (Anonymous Object)

Different from singleton:

```kotlin
val obj = object {
    val name = "Kotlin"
    fun greet() = "Hello"
}
```

This creates a one-time anonymous object.

---

# 8️⃣ Object Declaration vs Class

| `object`              | `class`                   |
| --------------------- | ------------------------- |
| One instance          | Many instances            |
| Auto created          | Created manually          |
| Good for shared logic | Good for modeling objects |

---

# 9️⃣ Thread Safety

Kotlin singletons are:

✔ Thread-safe by default
✔ Lazy initialized (created when first used)

You don’t need extra code.

---

# 🔟 When NOT to Use Singleton

❌ When you need multiple instances
❌ When you need dependency injection flexibility
❌ When testing becomes difficult

In Android modern apps, DI tools like:

* Hilt
* Dagger

are preferred instead of heavy singleton usage.

---

# 🎯 Summary

Singleton in Kotlin:

✔ Created using `object`
✔ Only one instance exists
✔ Thread-safe
✔ Lazy initialized
✔ Good for shared/global logic

---

