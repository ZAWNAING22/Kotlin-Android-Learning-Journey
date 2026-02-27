# 🧩 Interface and Abstract Classes in Kotlin

Both are used to achieve **abstraction** (hide implementation details and show only important behavior).

But they are used in slightly different ways.

---

# 🔹 1️⃣ Interface in Kotlin

An **interface** defines a contract (what a class must do), but usually does not store state.

---

## ✅ Basic Interface Example

```kotlin
interface Animal {
    fun makeSound()
}
```

Now any class that implements it must override the function:

```kotlin
class Dog : Animal {
    override fun makeSound() {
        println("Bark")
    }
}
```

Usage:

```kotlin
val dog = Dog()
dog.makeSound()
```

---

## 🔹 Interface with Multiple Methods

```kotlin
interface Vehicle {
    fun start()
    fun stop()
}
```

---

## 🔹 Interface Can Have Default Implementation

Unlike Java (old versions), Kotlin interfaces can have function bodies.

```kotlin
interface Animal {
    fun eat() {
        println("Eating")
    }
}
```

Class:

```kotlin
class Cat : Animal
```

`Cat` automatically gets `eat()` unless overridden.

---

## 🔹 Interface Properties

```kotlin
interface Person {
    val name: String
}
```

The implementing class must provide it:

```kotlin
class Student(override val name: String) : Person
```

---

## 🔥 Multiple Interface Inheritance (Very Important)

Kotlin allows implementing multiple interfaces:

```kotlin
interface A {
    fun show()
}

interface B {
    fun show()
}

class Test : A, B {
    override fun show() {
        println("Resolved conflict")
    }
}
```

You must override if both have same method.

---

# 🔹 2️⃣ Abstract Class in Kotlin

An **abstract class** can contain:

* Abstract methods (no body)
* Normal methods (with body)
* Properties
* Constructors
* State (variables)

---

## ✅ Basic Abstract Class Example

```kotlin
abstract class Shape {
    abstract fun area(): Double
}
```

Child class:

```kotlin
class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return 3.14 * radius * radius
    }
}
```

You CANNOT create object of abstract class:

```kotlin
val shape = Shape()  // ❌ Error
```

---

## 🔹 Abstract Class with Normal Function

```kotlin
abstract class Animal {
    abstract fun makeSound()

    fun sleep() {
        println("Sleeping")
    }
}
```

Child:

```kotlin
class Dog : Animal() {
    override fun makeSound() {
        println("Bark")
    }
}
```

---

# 🔥 Interface vs Abstract Class

| Interface              | Abstract Class                          |
| ---------------------- | --------------------------------------- |
| Defines contract       | Defines base class                      |
| Can implement multiple | Only one abstract class can be extended |
| No constructor         | Can have constructor                    |
| No state (usually)     | Can hold state                          |
| Used for capability    | Used for common base                    |

---

# 🎯 When to Use What?

## Use Interface When:

* You want to define behavior (like ability)
* Multiple classes share same capability
* Example: Clickable, Draggable, Serializable

## Use Abstract Class When:

* Classes share common logic
* Need constructor
* Need shared state

---

# 🎯 Real Android Example

### Interface Example (Click Listener)

```kotlin
interface OnClickListener {
    fun onClick()
}
```

Used heavily in Android UI development.

---

### Abstract Class Example (BaseActivity)

```kotlin
abstract class BaseActivity {
    fun setupUI() {
        println("Common UI setup")
    }

    abstract fun initView()
}
```

All activities extend this.

---

Kotlin was created by **JetBrains** and officially supported for Android by **Google**, and its interface/abstract design is cleaner than Java.

---

# 🚀 Final Simple Difference

👉 Interface = "What you can do"
👉 Abstract class = "What you are"

Example:

* Bird **is an** Animal → Abstract class
* Bird **can fly** → Interface

---


Just tell me 👍
