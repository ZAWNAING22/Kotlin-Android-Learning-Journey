# 🏗️ Classes and Constructors in Kotlin

In Kotlin, a **class** is a blueprint for creating objects.
Objects contain **properties (variables)** and **functions (methods)**.

---

# 🔹 1️⃣ Basic Class

### Simple Class Example

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    fun greet() {
        println("Hello, my name is $name")
    }
}
```

### Creating an Object

```kotlin
val person = Person()
person.name = "John"
person.age = 25
person.greet()
```

---

# 🔹 2️⃣ Primary Constructor (Most Common)

In Kotlin, constructors are written in the class header.

### Example:

```kotlin
class Person(val name: String, var age: Int)
```

This automatically creates:

* Properties
* Constructor
* Initialization

### Usage:

```kotlin
val person = Person("Alice", 22)
println(person.name)
```

👉 `val` / `var` inside constructor means:

* `val` → read-only property
* `var` → mutable property

---

# 🔹 3️⃣ Primary Constructor with Init Block

If you need logic during object creation, use `init`.

```kotlin
class Person(val name: String, var age: Int) {

    init {
        println("Person created: $name")
    }
}
```

`init` runs immediately when object is created.

---

# 🔹 4️⃣ Secondary Constructor

Sometimes you need multiple ways to create an object.

```kotlin
class Person {

    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor(name: String) {
        this.name = name
        this.age = 0
    }
}
```

Usage:

```kotlin
val p1 = Person("John", 25)
val p2 = Person("Alice")
```

---

# 🔹 5️⃣ Primary + Secondary Together

```kotlin
class Person(val name: String, var age: Int) {

    constructor(name: String) : this(name, 0)
}
```

`this(name, 0)` calls primary constructor.

---

# 🔥 Why Primary Constructor is Preferred?

Kotlin encourages shorter, cleaner code.

Instead of writing:

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

You simply write:

```kotlin
class Person(val name: String, var age: Int)
```

Much cleaner ✅

---

# 🎯 In Android Development

You use classes for:

* Activities
* Fragments
* ViewModels
* Data models
* Repository classes

Example:

```kotlin
data class User(val id: Int, val name: String)
```

Kotlin was created by **JetBrains** and officially supported by **Google** for Android, and its constructor design makes Android code much cleaner than Java.

---

# 📌 Summary

## Class

* Blueprint for objects
* Contains properties and functions

## Primary Constructor

* Written in class header
* Most common
* Cleaner and shorter

## Secondary Constructor

* Written inside class body
* Used for multiple initialization options

## `init` Block

* Runs when object is created
* Used for setup logic

---

