
# 📱 ViewModel and State Management in Compose

Modern Android apps use **MVVM architecture** with:

* Android Jetpack
* Jetpack Compose
* Kotlin Coroutines
* StateFlow

This creates clean, lifecycle-aware, scalable apps.

---

# 1️⃣ Why ViewModel Exists

Problem without ViewModel:

* Data lost on screen rotation
* UI logic mixed inside Activity
* Hard to test
* Memory leaks possible

Solution:

> ViewModel stores and manages UI-related data in a lifecycle-conscious way.

ViewModel survives:

* Screen rotation
* Configuration changes

---

# 2️⃣ What is MVVM?

MVVM stands for:

* **Model** → Data layer (Repository, API, Database)
* **View** → UI (Compose screen)
* **ViewModel** → Connects Model and View

Flow of data:

```text
User Action → ViewModel → Repository → ViewModel → UI
```

UI never talks directly to repository.

---

# 3️⃣ Basic ViewModel Example

```kotlin
class CounterViewModel : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increase() {
        _count.value++
    }
}
```

Important:

* `_count` is private
* `count` is exposed as immutable
* This protects state from external modification

---

# 4️⃣ Connecting ViewModel to Compose

In Compose screen:

```kotlin
@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {

    val count by viewModel.count.collectAsState()

    Column {
        Text("Count: $count")

        Button(onClick = { viewModel.increase() }) {
            Text("Increase")
        }
    }
}
```

Key function:

```kotlin
collectAsState()
```

This converts `StateFlow` into Compose state.

When value changes → UI recomposes automatically.

---

# 5️⃣ Lifecycle Awareness

ViewModel is lifecycle-aware because of:

Android Jetpack

If Activity is destroyed permanently:

* ViewModel is cleared
* `onCleared()` is called
* Coroutines inside `viewModelScope` are cancelled

Example:

```kotlin
override fun onCleared() {
    super.onCleared()
    println("ViewModel destroyed")
}
```

---

# 6️⃣ Using Coroutines in ViewModel

Example with async data:

```kotlin
class UserViewModel : ViewModel() {

    private val _state = MutableStateFlow("Loading")
    val state: StateFlow<String> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(2000)
            _state.value = "Data Loaded"
        }
    }
}
```

`viewModelScope` ensures:

* Automatic cancellation
* Structured concurrency
* No memory leaks

---

# 7️⃣ Recommended State Pattern (UI State)

Instead of multiple variables, use sealed class:

```kotlin
sealed interface UiState {
    object Loading : UiState
    data class Success(val data: String) : UiState
    data class Error(val message: String) : UiState
}
```

ViewModel:

```kotlin
private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
val uiState: StateFlow<UiState> = _uiState
```

Compose:

```kotlin
when (val state = uiState) {
    is UiState.Loading -> Text("Loading...")
    is UiState.Success -> Text(state.data)
    is UiState.Error -> Text(state.message)
}
```

This is professional-level architecture.

---

# 8️⃣ Why StateFlow Instead of LiveData?

Older Android used LiveData.

Modern apps prefer StateFlow because:

* Works with Coroutines
* More powerful operators
* Not Android-only
* Cleaner reactive model

---

# 9️⃣ Real Practice Project (You Should Build This)

Create:

### 🧱 User Loading Screen

* Show "Loading"
* After 2 seconds show "Success"
* Use:

  * ViewModel
  * StateFlow
  * viewModelScope
  * Compose

This combines everything you've learned.

---

# 🔟 Common Beginner Mistakes

❌ Holding Activity context inside ViewModel
❌ Exposing MutableStateFlow publicly
❌ Running network calls directly inside Composable
❌ Not using viewModelScope

---

# 🧠 Key Concepts Learned

* Why ViewModel exists
* MVVM architecture
* StateFlow for UI state
* Compose observing state
* Lifecycle awareness
* viewModelScope usage

---

# 🏁 Summary

Modern Android architecture:

* UI is declarative (Compose)
* State lives in ViewModel
* Data flows one direction
* Coroutines handle async work
* StateFlow updates UI reactively

You are now officially learning **real Android architecture**, not just UI basics.

