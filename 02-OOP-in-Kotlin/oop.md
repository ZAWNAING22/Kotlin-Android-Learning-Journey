🤖 OOP in Kotlin for Android Development
Object-Oriented Programming (OOP) is the backbone of Android. In Android development, almost everything—Activities, Fragments, Views, and RecyclerViews—is an object.

1. Classes & Objects
A Class is the blueprint; an Object is the actual house built from that blueprint.

Kotlin
// The Blueprint
class Person {
    var name: String = ""
    var age: Int = 0

    fun greet() {
        println("Hello, my name is $name")
    }
}

// The Instance
val p1 = Person()
p1.name = "Zaw"
p1.age = 23
p1.greet()
📱 Where is this used in Android?
Every screen you see is a class. When Android starts a screen, it instantiates an object of that class.

UI Components: class MainActivity : AppCompatActivity()

Logic: NetworkManager, DatabaseHelper, ImageLoader

2. Constructors
Constructors initialize your objects with data the moment they are created.

Primary vs. Secondary
Kotlin
// Primary: Concise and common
class User(val id: Int, val username: String)

// Secondary: Used when you need extra logic during initialization
class User {
    var id: Int
    var username: String

    constructor(id: Int, username: String) {
        this.id = id
        this.username = username
    }
}
📱 Where is this used in Android?
Model Classes: Defining the structure of a User or Product.

Adapters: Passing a list of data into a RecyclerView.Adapter.

class UserAdapter(private val userList: List<User>)

3. Inheritance
Inheritance allows one class to derive features from another. In Kotlin, you must use the open keyword to allow a class to be inherited.

Kotlin
open class Animal {
    fun eat() { println("Eating...") }
}

class Dog : Animal() {
    fun bark() { println("Barking!") }
}
📱 Where is this used in Android?
Android relies heavily on deep inheritance trees.

MainActivity ➡ inherits ➡ AppCompatActivity ➡ inherits ➡ FragmentActivity ➡ inherits ➡ Activity.

This is how your classes get access to lifecycle methods like onCreate() and onPause().

4. Interfaces
An interface defines behavior. It tells a class what to do, but not how to do it.

Kotlin
interface ClickListener {
    fun onClick()
}

class ButtonHandler : ClickListener {
    override fun onClick() {
        println("Button was tapped!")
    }
}
📱 Where is this used in Android?
User Interaction: setOnClickListener uses an interface to detect taps.

Communication: Sending data from a Fragment back to an Activity.

Callbacks: Handling API responses (Success vs. Failure).

5. Data Classes
Data classes are specialized classes used strictly to hold data. Kotlin automatically generates toString(), equals(), hashCode(), and copy().

Kotlin
data class Post(
    val id: Int,
    val title: String,
    val body: String
)
📱 Where is this used in Android?
Networking: Parsing JSON from Retrofit/Ktor into objects.

Database: Defining tables in a Room database.

State Management: Passing data between different screens.

6. Sealed Classes
Sealed classes allow you to represent restricted class hierarchies. Think of them as "Enums on steroids."

Kotlin
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<String>) : UiState()
    data class Error(val message: String) : UiState()
}
📱 Where is this used in Android?
MVVM Architecture: The ViewModel sends a Sealed Class state to the UI.

Result Handling: Managing the different states of a network request (Loading, Success, or Error).

⚡ The Big Picture: How it fits together
API returns JSON.

JSON is parsed into a Data Class.

The ViewModel holds this data in a Sealed Class state.

The Activity (Inheritance) observes that state.

The RecyclerView uses a Constructor to get the data.

The User clicks an item via an Interface.

🎯 Beginner Priority List
Must Master: Classes, Objects, Constructors, and Inheritance.

Level Up: Data Classes and Interfaces.

Pro Tier: Sealed Classes (Essential for modern MVVM/Jetpack Compose).
