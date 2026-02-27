# 🚀 Asynchronous Programming in Kotlin

## (Coroutines & Kotlin Flow)

Asynchronous programming means:

> Running long tasks **without blocking** the main thread.

Very important in **Android development** because you must never block the UI thread.

---

# 🧠 1️⃣ The Problem (Why Async?)

If you do this:

```kotlin
fun fetchData() {
    Thread.sleep(3000)
    println("Data Loaded")
}
```

⛔ The app freezes for 3 seconds.

In Android → this causes **ANR (Application Not Responding)**.

---

# ⚡ 2️⃣ Coroutines (Modern Solution)

Kotlin provides **Coroutines** via
Kotlin Coroutines

Coroutines are:

✔ Lightweight threads
✔ Non-blocking
✔ Easier than callbacks
✔ Structured concurrency

---

## 🔹 Basic Coroutine Example

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(2000)
        println("World")
    }
    println("Hello")
}
```

Output:

```
Hello
World
```

🔹 `launch` → starts coroutine
🔹 `delay()` → non-blocking delay
🔹 `runBlocking` → blocks main (used only for testing)

---

# 🔥 3️⃣ suspend Function

A function that can pause without blocking thread.

```kotlin
suspend fun fetchData(): String {
    delay(2000)
    return "Data"
}
```

You can only call it inside coroutine:

```kotlin
launch {
    val result = fetchData()
    println(result)
}
```

---

# 🧵 4️⃣ Dispatchers (Threads)

Coroutines use **Dispatchers** to decide thread:

```kotlin
launch(Dispatchers.IO) { }        // Network / DB
launch(Dispatchers.Main) { }      // UI thread
launch(Dispatchers.Default) { }   // Heavy computation
```

In Android:

* Network → IO
* UI update → Main

---

# 📱 Real Android Example

In Android ViewModel (using
Android Jetpack):

```kotlin
viewModelScope.launch {
    val data = repository.getData()
    _state.value = data
}
```

✔ Automatically canceled when ViewModel cleared
✔ Lifecycle-aware

---

# 🌊 5️⃣ Kotlin Flow

Coroutines handle **one-time async tasks**.

But what if you need:

> Continuous stream of data?

That’s where **Flow** comes.

Provided by:
Kotlin Flow

---

## 🔹 What is Flow?

Flow is:

> Cold asynchronous data stream.

Example:

* API updates
* Database changes
* User typing events

---

## 🔹 Basic Flow Example

```kotlin
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = flow {
        emit(1)
        emit(2)
        emit(3)
    }

    flow.collect {
        println(it)
    }
}
```

Output:

```
1
2
3
```

---

# 🔄 Flow vs Suspend

| suspend         | Flow            |
| --------------- | --------------- |
| One value       | Many values     |
| One-time result | Stream          |
| Like function   | Like observable |

---

# 🌡️ Cold vs Hot Flow

### ❄ Cold Flow

Starts emitting only when collected.

```kotlin
flow.collect { }
```

Each collector gets new execution.

---

### 🔥 Hot Flow

Examples:

* `StateFlow`
* `SharedFlow`

Used for:

* UI state
* Live updates

Example:

```kotlin
private val _state = MutableStateFlow("Loading")
val state: StateFlow<String> = _state
```

---

# 📊 6️⃣ Common Flow Operators

```kotlin
flow
    .filter { it > 2 }
    .map { it * 2 }
    .collect { println(it) }
```

Common operators:

* `map`
* `filter`
* `reduce`
* `debounce`
* `combine`
* `zip`

---

# 🏗️ Real Android Architecture Example

Repository:

```kotlin
fun getUsers(): Flow<List<User>> = flow {
    emit(api.getUsers())
}
```

ViewModel:

```kotlin
viewModelScope.launch {
    repository.getUsers()
        .collect { users ->
            _state.value = users
        }
}
```

UI automatically updates.

---

# 🔥 7️⃣ Flow vs LiveData

Older Android used:
LiveData

Modern apps prefer:
✔ Flow
✔ StateFlow

Because:

* More powerful
* More operators
* Works outside Android

---

# 🧠 8️⃣ Structured Concurrency

Coroutines follow:

> Parent coroutine controls child coroutines.

If parent is canceled → children canceled.

Prevents memory leaks.

---

# 🎯 When to Use What?

| Situation                | Use              |
| ------------------------ | ---------------- |
| API call                 | suspend function |
| Database stream          | Flow             |
| UI state                 | StateFlow        |
| One-time background task | launch           |
| Parallel tasks           | async/await      |

---

# 🚨 Common Mistakes

❌ Using `GlobalScope`
❌ Blocking thread with `Thread.sleep()`
❌ Updating UI from IO dispatcher
❌ Forgetting to cancel coroutine

---

# 🏁 Final Summary

## Coroutines

✔ Async programming
✔ Non-blocking
✔ Lightweight
✔ Structured

## Flow

✔ Async stream
✔ Cold by default
✔ Powerful operators
✔ Great for UI state

---

in Kotlin for Android, this is one of the MOST important topics.


