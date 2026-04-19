# JSON Parsing in Android/Kotlin — One Good Note

## 📌 What is JSON Parsing?

JSON parsing is the process of converting raw JSON text received from a server into structured data that your Android app can use.

In Kotlin/Android, the two main classes are:

* **`JSONObject`** → for a single object with key-value pairs
* **`JSONArray`** → for a list/array of values or objects

---

## 🔹 `JSONObject`

Used when JSON starts with `{ }`

### Example:

```json
{
  "name": "Alice",
  "age": 25
}
```

### Kotlin:

```kotlin
val obj = JSONObject(jsonString)

val name = obj.getString("name")
val age = obj.getInt("age")
```

---

## 🔹 `JSONArray`

Used when JSON starts with `[ ]`

### Example:

```json
[
  {"name":"Alice"},
  {"name":"Bob"}
]
```

### Kotlin:

```kotlin
val arr = JSONArray(jsonString)

for (i in 0 until arr.length()) {
    val person = arr.getJSONObject(i)
    val name = person.getString("name")
}
```

---

## 🔹 Real API Pattern (Most Common)

Usually APIs return:

```json
{
  "status":"ok",
  "users":[
    {"id":1,"name":"Alice"},
    {"id":2,"name":"Bob"}
  ]
}
```

### Parse Flow:

```kotlin
val root = JSONObject(response)
val users = root.getJSONArray("users")

for (i in 0 until users.length()) {
    val user = users.getJSONObject(i)
    val name = user.getString("name")
}
```

---

## 🔹 Why Parsing is Needed?

Because server response is plain text. Parsing turns it into usable structured data.

---

## 🔹 In Android App Workflow

1. Get JSON from API (Volley / Retrofit)
2. Parse using `JSONObject` / `JSONArray`
3. Store in ArrayList / Data Class
4. Show in RecyclerView / ListView

---

## 🔹 Interview Style Summary

| Class        | Used For         |
| ------------ | ---------------- |
| `JSONObject` | Single object    |
| `JSONArray`  | Multiple objects |

---

## 🔹 Best Practice (Modern Android)

Use **Retrofit + Gson / Kotlinx Serialization** instead of manual parsing for big projects.

---

## 🔥 Easy Memory Trick

* `{ }` = One object = `JSONObject`
* `[ ]` = Many objects = `JSONArray`

---
