## 1. What is JSON?

**JSON** stands for **JavaScript Object Notation**.

It is a **lightweight data format used to exchange data between systems**, especially between **servers and applications** like Android apps.

In simple words:

> **JSON is a structured way to send and receive data.**

Most **APIs send data in JSON format**, and Android apps read that data.

---

## 2. Why JSON is Used in Android

When an Android app calls an **API**, the server usually returns **JSON data**.

Example:

Weather app → request weather data
Server → returns **JSON**

The Android app then **parses the JSON and shows it in UI**.

Example uses in Android:

• Loading user profiles
• Displaying posts in a list
• Getting weather information
• Login responses
• Product lists in shopping apps

---

## 3. JSON Basic Structure

JSON is made of **key–value pairs**.

General format:

```json
{
  "key": "value"
}
```

Example:

```json
{
  "name": "John",
  "age": 25,
  "city": "London"
}
```

Explanation:

| Key  | Value  |
| ---- | ------ |
| name | John   |
| age  | 25     |
| city | London |

---

## 4. JSON Data Types

JSON supports several value types.

| Type    | Example              |
| ------- | -------------------- |
| String  | `"name": "John"`     |
| Number  | `"age": 25`          |
| Boolean | `"isStudent": true`  |
| Object  | `"address": {}`      |
| Array   | `"courses": []`      |
| Null    | `"middleName": null` |

Example:

```json
{
  "name": "Ali",
  "age": 22,
  "isStudent": true
}
```

---

## 5. JSON Object

An **object** contains multiple key–value pairs.

Example:

```json
{
  "user": {
    "id": 1,
    "name": "Sara",
    "email": "sara@email.com"
  }
}
```

Here **user** is an object.

---

## 6. JSON Array

An **array** stores multiple items.

Example:

```json
{
  "students": [
    {"name": "Ali"},
    {"name": "John"},
    {"name": "Sara"}
  ]
}
```

Array uses **square brackets `[ ]`**.

---

## 7. Real API JSON Example

Typical API response:

```json
{
  "id": 10,
  "title": "Android Development",
  "author": "Alex",
  "comments": [
    {
      "user": "Sara",
      "message": "Great article"
    },
    {
      "user": "John",
      "message": "Very helpful"
    }
  ]
}
```

This type of JSON is **very common in Android apps**.

---

## 8. JSON → Kotlin Data Class

Android converts JSON into **Kotlin objects**.

JSON:

```json
{
  "id": 1,
  "name": "Ali",
  "email": "ali@email.com"
}
```

Kotlin:

```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

Libraries automatically convert JSON to objects, such as:

* Gson
* Moshi

---

## 9. JSON in Android Workflow

Typical Android flow:

```
Android App
     ↓
API Request
     ↓
Server
     ↓
JSON Response
     ↓
Convert JSON → Kotlin Data Class
     ↓
Display in UI (RecyclerView / Compose)
```

Example:

News app

```
Server → JSON posts
        ↓
Android converts to objects
        ↓
RecyclerView shows list
```

---

## 10. JSON Syntax Rules

Important rules:

1. Data is in **key : value pairs**
2. Keys must be **in double quotes**
3. Objects use **{ }**
4. Arrays use **[ ]**
5. Items are separated by **comma**

Example:

```json
{
  "name": "Ali",
  "age": 22,
  "courses": ["Android", "Kotlin", "AI"]
}
```

---

## 11. Why JSON is Popular

Advantages:

• Easy to read
• Lightweight
• Works with almost all languages
• Perfect for **web and mobile APIs**

That is why almost every Android API uses **JSON**.

---

✅ Since you are learning **Android**, the **next important concept after JSON** is:

**JSON → Kotlin → RecyclerView / UI**

and the libraries used for it:

* Retrofit
* Gson


