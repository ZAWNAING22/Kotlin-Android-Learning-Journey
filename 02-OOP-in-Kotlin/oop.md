🚀 Kotlin OOP for Android Development
This guide explains core Object-Oriented Programming (OOP) concepts in Kotlin and demonstrates exactly how they are applied in real-world Android development.

1️⃣ OOP in Kotlin
OOP is a paradigm based on the concept of "objects," which can contain data and code. In Android, almost everything you interact with is an object:

Activities & Fragments

Views & ViewGroups (Buttons, TextViews)

RecyclerViews & Adapters

2️⃣ Classes & Objects
Class: A blueprint or template.

Object: A specific instance created from that blueprint.

Kotlin
class Person {
    var name: String = ""
    var age: Int = 0

    fun greet() {
        println("Hello, my name is $name")
    }
}

// Creating an Object
val p1 = Person()
p1.name = "Zaw"
p1.age = 23
p1.greet()
📱 Where is this used in Android?
Every screen in your app is a class. When the system starts a screen, it creates an object of that class.

class MainActivity : AppCompatActivity()

Common objects: User, Product, NetworkManager, DatabaseHelper.

3️⃣ Constructors
Constructors are used to initialize an object's properties when it is first created.

Primary vs. Secondary
Kotlin
// Primary Constructor (Most Common)
class Person(val name: String, val age: Int)

// Secondary Constructor (Using the 'constructor' keyword)
class Person {
    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
📱 Where is this used in Android?
Model Classes: Creating a User(id = 1, name = "Zaw").

RecyclerView Adapters: Passing a list of data into an adapter:
class UserAdapter(private val userList: List<User>)

4️⃣ Inheritance
Inheritance allows a child class to adopt the properties and methods of a parent class. In Kotlin, classes are final by default; you must use the open keyword to allow inheritance.

Kotlin
open class Animal {
    fun eat() { println("Eating...") }
}

class Dog : Animal() {
    fun bark() { println("Barking!") }
}
📱 Where is this used in Android?
Android is built on inheritance. When you write:
class MainActivity : AppCompatActivity()
You are inheriting all the complex logic for screen management and lifecycle methods (like onCreate) from the Android Framework.

5️⃣ Interfaces
An interface defines a behavior (contract) without providing the logic. A class "implements" the interface to provide the actual code.

Kotlin
interface ClickListener {
    fun onClick()
}

class ButtonHandler : ClickListener {
    override fun onClick() {
        println("Button Clicked!")
    }
}
📱 Where is this used in Android?
Click Events: button.setOnClickListener { ... } uses an interface behind the scenes.

API Callbacks: Handling data coming back from a server (e.g., onSuccess or onFailure).

6️⃣ Data Classes
Data classes are specialized classes whose main purpose is to hold data. Kotlin automatically generates toString(), equals(), hashCode(), and copy().

Kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
📱 Where is this used in Android?
Retrofit/API Models: Mapping JSON data from the web into Kotlin objects.

Room Database: Defining tables to store data locally on the phone.

7️⃣ Sealed Classes
Sealed classes represent restricted class hierarchies. They are like "Enums on steroids" because each subclass can hold its own unique data.

Kotlin
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<User>) : UiState()
    data class Error(val message: String) : UiState()
}
📱 Where is this used in Android?
MVVM Architecture: Managing UI states in a ViewModel.

State Management: Handling the transition between showing a Loading spinner, showing the Success data, or an Error message.

🔥 Summary: How it all fits together
In a professional Android app flow:

API returns JSON data.

Data is parsed into a Data Class.

The ViewModel wraps that data in a Sealed Class (Success/Error).

The Activity (Inheritance) observes that state.

The RecyclerView Adapter uses a Constructor to receive the data.

The User clicks an item via an Interface.

🎯 Beginner Priority List
✅ Master: Classes, Objects, Constructors, and Inheritance.

⚡ Deep Dive: Interfaces and Data Classes.

🏆 Pro Tier: Sealed Classes (Essential for modern MVVM/Compose apps).
