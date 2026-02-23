 These are **core OOP concepts in Kotlin**, and they are heavily used in **Android development**. I’ll explain each clearly and then tell you **where and how it is used in Android apps**.

---

# 1️⃣ OOP in Kotlin

**OOP (Object-Oriented Programming)** is a way of writing code using:

* Objects
* Classes
* Reusability
* Encapsulation
* Inheritance
* Abstraction

In Android, almost everything is an object:

* `Activity`
* `Fragment`
* `View`
* `RecyclerView`
* etc.

Android itself is built using OOP principles.

---

# 2️⃣ Classes & Objects

## 🔹 What is a Class?

A **class** is a blueprint.

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    fun greet() {
        println("Hello")
    }
}
```

## 🔹 What is an Object?

An **object** is an instance of a class.

```kotlin
val p1 = Person()
p1.name = "Zaw"
p1.age = 23
p1.greet()
```

---

## 📱 Where used in Android?

Every screen in Android is a class:

```kotlin
class MainActivity : AppCompatActivity() {
}
```

`MainActivity` is a class.

When Android starts the screen → it creates an object of that class.

You also create classes for:

* User
* Product
* NetworkManager
* DatabaseHelper
* etc.

---

# 3️⃣ Constructors

A constructor initializes values when an object is created.

## 🔹 Primary Constructor

```kotlin
class Person(val name: String, val age: Int)
```

Usage:

```kotlin
val p1 = Person("Zaw", 23)
```

## 🔹 Secondary Constructor

```kotlin
class Person {
    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
```

---

## 📱 Where used in Android?

Very common in:

### 🔹 Model Classes

```kotlin
class User(val id: Int, val username: String)
```

### 🔹 RecyclerView Adapter

```kotlin
class UserAdapter(private val userList: List<User>)
```

When you pass data into adapter → that uses constructor.

---

# 4️⃣ Inheritance

Inheritance allows one class to inherit from another.

In Kotlin, classes are `final` by default.
You must use `open` to allow inheritance.

```kotlin
open class Animal {
    fun eat() {
        println("Eating")
    }
}

class Dog : Animal() {
    fun bark() {
        println("Barking")
    }
}
```

---

## 📱 Where used in Android?

Android uses inheritance everywhere.

Example:

```kotlin
class MainActivity : AppCompatActivity()
```

Here:

* `MainActivity` inherits from `AppCompatActivity`
* `AppCompatActivity` inherits from `Activity`

Android lifecycle methods (like `onCreate`) come from inheritance.

---

# 5️⃣ Interfaces

An interface defines behavior without implementation.

```kotlin
interface ClickListener {
    fun onClick()
}
```

Class implements it:

```kotlin
class ButtonHandler : ClickListener {
    override fun onClick() {
        println("Clicked")
    }
}
```

---

## 📱 Where used in Android?

Very common in:

### 🔹 Click Listeners

```kotlin
button.setOnClickListener {
    // action
}
```

Behind the scenes, this uses an interface.

### 🔹 RecyclerView item clicks

You create interface for item click communication.

### 🔹 API callbacks

When getting response from server.

---

# 6️⃣ Data Classes

Data classes are used to hold data.

They automatically generate:

* `toString()`
* `equals()`
* `hashCode()`
* `copy()`

Example:

```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

---

## 📱 Where used in Android?

Very important in:

### 🔹 API Response Models

When using:

* Retrofit
* Firebase
* Room database

Example:

```kotlin
data class Post(
    val title: String,
    val body: String
)
```

Used to:

* Parse JSON
* Store database records
* Pass data between activities

---

# 7️⃣ Sealed Classes

Sealed classes restrict class hierarchy.

Used when you have **fixed types**.

Example:

```kotlin
sealed class Result {
    class Success(val data: String) : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}
```

---

## 📱 Where used in Android?

Very important in:

### 🔹 Handling UI States

Example in ViewModel:

```kotlin
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<User>) : UiState()
    data class Error(val message: String) : UiState()
}
```

Used for:

* Loading state
* Success state
* Error state

This is very common in:

* MVVM architecture
* Clean Architecture
* Jetpack Compose

---

# 🔥 How All These Work Together in Android

Example flow in real Android app:

1. API returns JSON
2. Convert JSON → `data class`
3. Store in `Repository` class
4. `ViewModel` exposes `sealed class` state
5. `Activity` inherits from `AppCompatActivity`
6. RecyclerView adapter uses constructor
7. Click events use interface

Everything is connected.

---

# 🎯 What You Should Focus On As Beginner Android Dev

For you (since you're learning Android with Kotlin):

✅ Master:

* Classes & Objects
* Constructors
* Inheritance
* Data classes

⚡ Then learn deeply:

* Interfaces
* Sealed classes (important for MVVM)

---

