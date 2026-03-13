

# 1️⃣ REST API

**REST API** (Representational State Transfer API) is a **standard way for apps to communicate with servers over the internet**.

Your Android app sends a **request** and the server sends back **data**.

Example request:

```
GET https://api.example.com/users
```

Server response (usually JSON):

```json
{
  "id": 1,
  "name": "Ali",
  "email": "ali@email.com"
}
```

### Main HTTP Methods

| Method | Purpose         |
| ------ | --------------- |
| GET    | Fetch data      |
| POST   | Create new data |
| PUT    | Update data     |
| DELETE | Remove data     |

Example in a social app:

```
GET /posts
POST /posts
DELETE /posts/10
```

REST APIs are used in almost **every Android app**.

Examples:

* Instagram → load posts
* Uber → get driver location
* Weather apps → fetch weather

---

# 2️⃣ JSON Parsing

Most APIs return **JSON data**.

JSON is just **structured text representing data**.

Example JSON:

```json
{
  "id": 5,
  "title": "Android Guide",
  "author": "Sara"
}
```

Android apps **cannot directly use JSON**, so we **convert JSON into Kotlin objects**.

Example Kotlin data class:

```kotlin
data class Post(
    val id: Int,
    val title: String,
    val author: String
)
```

Libraries used for JSON parsing:

* Gson
* Moshi

These libraries automatically convert:

```
JSON → Kotlin Object
```

---

# 3️⃣ Retrofit

Retrofit is the **most popular library used in Android to call APIs**.

It simplifies networking.

Instead of writing complex network code, you define an **API interface**.

Example:

```kotlin
interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}
```

Retrofit will:

1. Send the network request
2. Receive the response
3. Convert JSON to Kotlin objects

So developers **write very little code**.

---

# 4️⃣ OkHttp

OkHttp is the **low-level networking library that actually sends HTTP requests**.

Important fact:

> Retrofit **uses OkHttp internally**.

Think of it like this:

```
Retrofit → High level API library
OkHttp → Low level network engine
```

OkHttp handles:

* HTTP requests
* connection management
* caching
* logging
* timeouts

Example raw request (without Retrofit):

```kotlin
val client = OkHttpClient()

val request = Request.Builder()
    .url("https://api.example.com/users")
    .build()
```

But most Android developers **use Retrofit instead of writing this manually**.

---

# 5️⃣ Coroutines with API Calls

Network requests take time.

If we run them on the **main thread**, the app will **freeze**.

Kotlin **coroutines** solve this problem.

They allow asynchronous operations.

Example:

```kotlin
viewModelScope.launch {
    val users = api.getUsers()
}
```

Coroutines allow:

* background execution
* non-blocking UI
* simpler async code

Without coroutines, developers had to use:

* callbacks
* AsyncTask (deprecated)

Now **coroutines are the standard**.

---

# How All 5 Work Together

In a real Android app:

```
Android App
     ↓
Coroutines
     ↓
Retrofit
     ↓
OkHttp
     ↓
REST API (Server)
     ↓
JSON Response
     ↓
JSON Parsing
     ↓
Kotlin Data Class
     ↓
UI (RecyclerView / Compose)
```

Example flow:

1. User opens app
2. Coroutine starts API call
3. Retrofit sends request
4. OkHttp handles network
5. Server returns JSON
6. JSON parsed into Kotlin objects
7. UI displays the data

---

# Simple Real Example

Suppose you open a **news app**.

```
GET https://newsapi.com/posts
```

Response:

```json
[
 { "title": "Tech News" },
 { "title": "World News" }
]
```

App process:

```
Coroutine
 ↓
Retrofit
 ↓
OkHttp
 ↓
Server
 ↓
JSON
 ↓
Data class
 ↓
RecyclerView
```

---

# What You Actually Need to Master (Student Level)

You **don’t need deep networking knowledge**.

Focus on:

1. REST API basics
2. JSON structure
3. Data classes
4. Retrofit
5. Coroutines in ViewModel

OkHttp knowledge can stay **basic**.

---
---
I'll explain these Android networking concepts in simple terms:

## 1️⃣ **REST API**
Think of it like a restaurant menu:
- **Client** (you) = Your app
- **Server** (kitchen) = Remote computer with data
- **API** (menu) = List of available actions

**Common REST actions:**
- `GET` = Get data (like checking menu)
- `POST` = Add new data (like placing order)
- `PUT` = Update data (like modifying order)
- `DELETE` = Remove data (like canceling order)

**Example:**
```
GET https://api.example.com/users    → Get all users
GET https://api.example.com/users/1  → Get user with ID 1
POST https://api.example.com/users    → Add new user
```

## 2️⃣ **JSON Parsing**
JSON is like a digital form of communication between app and server.

**Raw JSON response:**
```json
{
  "name": "John",
  "age": 25,
  "email": "john@email.com"
}
```

**In Kotlin (data class):**
```kotlin
data class User(
    val name: String,
    val age: Int,
    val email: String
)
```

**Parsing libraries** (like Gson/Moshi) automatically convert:
- JSON → Kotlin object (when receiving data)
- Kotlin object → JSON (when sending data)

## 3️⃣ **Retrofit**
Retrofit is like a delivery service that handles all the complex networking for you.

**How it works:**
1. You define what you want (interface)
2. Retrofit handles how to get it

**Example:**
```kotlin
// Define your API service
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
    
    @POST("users")
    suspend fun createUser(@Body user: User): User
}

// Create Retrofit instance
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.example.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// Use it
val api = retrofit.create(ApiService::class.java)
val users = api.getUsers() // Actually makes network call
```

## 4️⃣ **OkHttp**
OkHttp is the actual "postman" that delivers the requests. Retrofit uses OkHttp underneath.

**What OkHttp does:**
- Actually sends the HTTP requests
- Handles connection pooling (reuses connections)
- Manages caching
- Retries failed requests
- Logs network activity

**Common uses:**
```kotlin
// Add logging
val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor())
    .connectTimeout(30, TimeUnit.SECONDS)
    .build()

// Attach to Retrofit
Retrofit.Builder()
    .client(client)  // Use custom OkHttp client
    .build()
```

## 5️⃣ **Coroutines with API Calls**
Coroutines help handle network calls without freezing your app.

**The Problem:**
Network calls take time (1-5 seconds). Without coroutines, your app would freeze during this time.

**The Solution (Coroutines):**
```kotlin
// In ViewModel
fun loadUsers() {
    viewModelScope.launch {  // Launch coroutine
        try {
            val users = api.getUsers()  // Suspends here, but app doesn't freeze
            // Update UI with users
        } catch (e: Exception) {
            // Handle error
        }
    }
}
```

**Why use coroutines:**
- **Non-blocking**: App stays responsive
- **Structured**: Easy to manage multiple calls
- **Automatic cancellation**: Stop calls when not needed

## **Complete Simple Example**

```kotlin
// 1. Data class (JSON parsing)
data class User(
    val id: Int,
    val name: String,
    val email: String
)

// 2. API interface (Retrofit)
interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<User>
}

// 3. Setup Retrofit with OkHttp
val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor())
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.example.com/")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api = retrofit.create(UserApi::class.java)

// 4. Use in ViewModel with Coroutines
class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users
    
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val result = api.getUsers()  // Network call
                _users.value = result        // Update UI
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
```

**Flow:**
1. User clicks button → `fetchUsers()` called
2. Coroutine launches (app stays responsive)
3. Retrofit uses OkHttp to make REST API call
4. Server responds with JSON
5. JSON automatically parsed into User objects
6. UI updates with the data

This combo makes networking in Android simple and efficient!

