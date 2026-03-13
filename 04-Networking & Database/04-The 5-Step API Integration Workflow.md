

---

# 1️⃣ Add Dependencies

### What it means

Before using libraries like **Retrofit** or **Gson**, you must add them to your project.

Android uses **Gradle** to manage libraries.

### Where?

`build.gradle (Module: app)`

### Example

```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

### Why?

These libraries help you:

* Call APIs easily
* Convert JSON → Kotlin objects automatically

---

# 2️⃣ Create Data Class (Model)

### What it means

APIs usually return **JSON data** like this:

```json
{
  "id": 1,
  "name": "John",
  "email": "john@email.com"
}
```

You create a **Kotlin data class** that matches this structure.

### Example

```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

### Why?

So **Retrofit + Gson** can automatically convert:

```
JSON  → Kotlin Object
```

Example result:

```
User(id=1, name=John, email=john@email.com)
```

---

# 3️⃣ API Interface

### What it means

You define **what API calls your app can make**.

Example API:

```
GET https://api.example.com/users
```

### Kotlin Interface Example

```kotlin
interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>

}
```

### Explanation

| Part               | Meaning               |
| ------------------ | --------------------- |
| `interface`        | Defines API endpoints |
| `@GET`             | HTTP request type     |
| `"users"`          | API endpoint          |
| `Call<List<User>>` | Expected response     |

This tells Retrofit:

> "When I call `getUsers()`, send a GET request to `/users`."

---

# 4️⃣ Get Data in Main (Make Network Call)

Now you **build Retrofit and call the API**.

### Retrofit Builder

```kotlin
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.example.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
```

### Create API service

```kotlin
val api = retrofit.create(ApiService::class.java)
```

### Call API

```kotlin
api.getUsers().enqueue(object : Callback<List<User>> {

    override fun onResponse(
        call: Call<List<User>>,
        response: Response<List<User>>
    ) {
        val users = response.body()
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        println("Error")
    }

})
```

### Why `enqueue()`?

Android **cannot run network requests on the main thread**.

Otherwise the app will **freeze (ANR error)**.

So `enqueue()` runs the request **in background**.

---

# 5️⃣ Populate Data in View

Now you show the data on screen.

Example response:

```
[
 {id:1, name:"John"},
 {id:2, name:"Alice"}
]
```

You display it using UI components like:

* **RecyclerView**
* **TextView**

### Example

```kotlin
textView.text = users[0].name
```

Or in **RecyclerView** list.

Result in app:

```
John
Alice
David
```

---

# 📊 Complete Flow (Very Important)

```
API Server
     ↓
JSON Response
     ↓
Retrofit
     ↓
Gson converts JSON → Kotlin Object
     ↓
App receives Data
     ↓
Show in RecyclerView / TextView
```

---

# 🧠 Real App Example

Weather App:

```
API → weather data
↓
Retrofit fetches data
↓
Model class stores it
↓
MainActivity receives it
↓
UI shows temperature
```

---

# 🎯 For Your Android Learning Path

Since you're studying Android, the **correct order** is:

1️⃣ REST API concept
2️⃣ JSON structure
3️⃣ Retrofit
4️⃣ Gson converter
5️⃣ Display with RecyclerView
6️⃣ Coroutines (modern way)


