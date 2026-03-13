

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

