### 1. What is an API?

**API** stands for **Application Programming Interface**.

In simple terms:

> An **API is a bridge that allows two software systems to talk to each other.**

You **send a request** → the system **processes it** → it **returns data (response)**.

Think of it like a **waiter in a restaurant**:

| Real Life      | Software          |
| -------------- | ----------------- |
| You (customer) | Android App       |
| Waiter         | API               |
| Kitchen        | Server / Database |
| Food           | Data              |

Flow:

1. Android app asks for data
2. API sends request to server
3. Server processes it
4. API returns data to the app

---

### 2. Example API Response (JSON)

Most Android apps receive data in **JSON format**.

Example:

```json
{
  "userId": 1,
  "name": "John",
  "email": "john@email.com"
}
```

Your Android app **reads this data and shows it on the screen**.

---

### 3. Why APIs are Important in Android

Without APIs, apps would have **no dynamic data**.

APIs allow apps to get:

• User data
• Posts / comments
• Weather information
• Maps data
• Login authentication
• Payment processing

Examples:

| App         | API Use            |
| ----------- | ------------------ |
| Instagram   | Load posts         |
| WhatsApp    | Send messages      |
| Uber        | Get location data  |
| Weather app | Fetch weather data |

---

### 4. Example Flow in Android App

Suppose you open a **news app**.

Steps:

1️⃣ App starts
2️⃣ App calls API

```
GET https://api.news.com/posts
```

3️⃣ Server returns JSON

```json
[
 { "title": "Tech News", "author": "Alex" },
 { "title": "World News", "author": "Sara" }
]
```

4️⃣ Android app shows it in **RecyclerView**

```
RecyclerView
   ↓
List of News
   ↓
UI updates
```

---

### 5. How Android Apps Use APIs

Android apps usually use libraries like:

• **Retrofit** → Most popular API library
• **OkHttp** → Network requests
• **Gson** → Convert JSON to Kotlin objects

Example Kotlin API interface:

```kotlin
interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}
```

---

### 6. API Request Types (HTTP Methods)

| Method | Use           |
| ------ | ------------- |
| GET    | Get data      |
| POST   | Send new data |
| PUT    | Update data   |
| DELETE | Remove data   |

Example:

```
GET /users
POST /users
DELETE /users/1
```

---

### 7. Where API Fits in Android Architecture

Typical Android architecture:

```
UI (Compose / XML)
        ↓
ViewModel
        ↓
Repository
        ↓
API Service (Retrofit)
        ↓
Server
```

The **API layer connects your app to the internet**.

---

### 8. Real Example Android Flow

User opens app →

```
ViewModel
   ↓
Repository
   ↓
Retrofit API call
   ↓
Server response (JSON)
   ↓
Convert to Kotlin Data Class
   ↓
Show in UI (RecyclerView / Compose)
```

---

### 9. Simple Definition (For Exams)

You can write:

> **API (Application Programming Interface)** is a set of rules that allows different software applications to communicate with each other and exchange data over the network.

---

✅ Since you are learning **Android + Kotlin**, the **next important topics after API** are:

1️⃣ **REST API**
2️⃣ **JSON parsing**
3️⃣ **Retrofit**
4️⃣ **OkHttp**
5️⃣ **Coroutines with API calls**

---

