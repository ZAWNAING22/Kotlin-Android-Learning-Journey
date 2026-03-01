
# 📱 Coroutines in Android

In Kotlin, you already know how to use coroutines.
In Android, the **lifecycle matters**, so coroutine usage changes slightly.

---

# 1️⃣ Why Not GlobalScope?

```kotlin id="1q0r2a"
GlobalScope.launch {
    delay(2000)
    println("Done")
}
```

❌ Problem in Android:

* Not lifecycle-aware
* Memory leaks possible
* UI may be gone when coroutine finishes

**Rule:** Never use `GlobalScope` for UI-related work.

---

# 2️⃣ Lifecycle-Aware Coroutine Scopes

### 🔹 viewModelScope

* Built into **ViewModel**
* Coroutine automatically canceled when ViewModel is cleared

Example:

```kotlin id="2s1m5b"
class UserViewModel : ViewModel() {

    private val _state = MutableStateFlow("Loading")
    val state: StateFlow<String> = _state

    fun loadData() {
        viewModelScope.launch {
            delay(2000)
            _state.value = "Data Loaded"
        }
    }
}
```

✅ Perfect for **UI state management**

---

### 🔹 lifecycleScope

* Available in **Activity / Fragment**
* Coroutine automatically canceled when Activity/Fragment is destroyed

Example:

```kotlin id="3x9a0v"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(2000)
            println("Activity still alive")
        }
    }
}
```

✅ Perfect for **short-lived UI tasks**, like animations or temporary data fetch.

---

# 3️⃣ Flow Collection in UI

In Android, you often collect **StateFlow** or **Flow** inside UI.

### 🔹 XML / Traditional Way

```kotlin id="4y5b7n"
lifecycleScope.launch {
    viewModel.state.collect { value ->
        textView.text = value
    }
}
```

* Coroutine automatically canceled if Activity is destroyed
* Prevents memory leaks

---

### 🔹 Compose Way

```kotlin id="5h8d2p"
@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    Text("State: $state")
}
```

* Compose observes `StateFlow` directly
* Automatic recomposition on state change
* No manual lifecycle handling needed

---

# 4️⃣ Best Practices

* Always use `viewModelScope` for ViewModel coroutines
* Always use `lifecycleScope` for Activity/Fragment UI coroutines
* Use `collectAsState()` in Compose
* Avoid `GlobalScope` and blocking operations
* Use `Dispatchers.IO` for network/database calls

---

# 5️⃣ Example: Loading Users in Compose

```kotlin id="6m9k1r"
class UsersViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<String>>(emptyList())
    val users: StateFlow<List<String>> = _users

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = loadUsersFromApi()
            _users.value = result
        }
    }
}

@Composable
fun UsersScreen(viewModel: UsersViewModel = viewModel()) {
    val users by viewModel.users.collectAsState()

    LazyColumn {
        items(users) { user ->
            Text(user)
        }
    }
}
```

✅ Fully lifecycle-aware, modern Android coroutine pattern.

---

# 6️⃣ Common Mistakes

❌ Collecting Flows without scope → memory leaks
❌ Running heavy tasks on `Dispatchers.Main`
❌ Using `GlobalScope` for UI work
❌ Ignoring cancellation on Activity/Fragment destruction

---

# 🧠 Key Concepts Learned

* viewModelScope vs lifecycleScope
* Flow collection in UI
* Compose vs XML flow observation
* Dispatcher usage in Android
* Lifecycle-aware coroutines

---

# 🏁 Summary

Modern Android + Coroutines:

* Use **viewModelScope** for ViewModel
* Use **lifecycleScope** for UI components
* Use **Flow / StateFlow** for reactive state
* Compose + collectAsState simplifies lifecycle handling

With this, your Kotlin + Android coroutine knowledge is fully integrated.


Do you want me to continue with **MVVM advanced patterns** next?
