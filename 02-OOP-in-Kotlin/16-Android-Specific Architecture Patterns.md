

---

# 1️⃣ Annotated Classes in Android

Annotations in Kotlin/Android are **metadata** attached to classes, functions, or properties. They **tell the compiler or libraries how to treat the code**.

Some common Android annotations:

---

## 🔹 @Composable (Jetpack Compose)

```kotlin id="x2d1hw"
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
```

* Marks a function as **Composable** → can be used to build UI.
* Compose compiler plugin uses this metadata to generate UI code.
* You **cannot call a @Composable function like a normal function** outside a Compose context.

📌 Use it for:

* UI screens
* Reusable UI components
* State-driven UI

---

## 🔹 @Entity (Room)

```kotlin id="nx5ctw"
@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val name: String
)
```

* Tells Room that this data class represents a **database table**.
* Room uses Kotlin metadata to generate SQL queries automatically.
* Other annotations like `@PrimaryKey`, `@ColumnInfo` also work together.

📌 Use it for:

* Local database
* Offline caching
* Structured persistence

---

## 🔹 @HiltAndroidApp (Dependency Injection)

```kotlin id="gj8uw1"
@HiltAndroidApp
class MyApp : Application()
```

* Marks the Application class for **Hilt DI**.
* Hilt uses Kotlin metadata to generate code for **dependency injection**.
* Allows you to inject dependencies (like ViewModels, Repositories) automatically.

📌 Use it for:

* App-wide dependency management
* Simplifying ViewModel injection
* Modular apps

---

### ⚡ Key Point About Annotations

* They **do not change runtime behavior by themselves**.
* Libraries/frameworks (Compose, Room, Hilt) **read these annotations** at compile-time.
* Kotlin metadata makes these annotations very smooth to integrate.

---

# 2️⃣ Sealed Interfaces (UI State Management)

### 🔹 What is a Sealed Interface?

Sealed Interfaces are like Sealed Classes:

> A **restricted type hierarchy**. Only known implementations are allowed at compile-time.

---

## 🔹 Why use Sealed Interface?

* Represent **UI states** in a screen:

  * Loading
  * Success
  * Error
* Each state can carry data.
* Compiler knows all possibilities → safer than enums.

---

## 🔹 Example: UI State

```kotlin id="n43sgh"
sealed interface UiState

data class Success(val users: List<User>) : UiState
object Loading : UiState
data class Error(val message: String) : UiState
```

---

### 🔹 Usage in a Compose Screen

```kotlin id="f1jsr4"
@Composable
fun UserScreen(uiState: UiState) {
    when (uiState) {
        is Loading -> CircularProgressIndicator()
        is Success -> UserList(users = uiState.users)
        is Error -> Text(text = uiState.message)
    }
}
```

✅ Benefits:

* **Exhaustive checking:** If you forget a case, compiler warns you.
* **Type-safe:** Each state carries its own data.
* **Readable and maintainable:** Very clear UI logic.

---

### 🔹 Difference Between Sealed Class vs Sealed Interface

| Feature                         | Sealed Class          | Sealed Interface                       |
| ------------------------------- | --------------------- | -------------------------------------- |
| Can inherit multiple            | ❌ Only one superclass | ✅ Can implement multiple interfaces    |
| Can be implemented outside file | ❌ No                  | ✅ Yes (if in same module, Kotlin 1.5+) |
| Typical use                     | Complex hierarchies   | UI states, simple hierarchies          |

💡 **Modern recommendation:** For **UI states**, **Sealed Interface** is preferred for flexibility and modularity.

---

# 🎯 Summary

1. **Annotated Classes**: Metadata that tells Android libraries how to treat code (`@Composable`, `@Entity`, `@HiltAndroidApp`).
2. **Sealed Interfaces**: Modern way to represent restricted hierarchies like **UI states**, safer than enums, very readable in Compose.

---
