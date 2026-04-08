
 **SQLite in Kotlin (Android)** in a clear, practical way.

---

# 🧠 What is SQLite?

**SQLite** is a **lightweight local database** built into Android.

* No server needed ✅
* Stored as a file on device 📱
* Used for **offline data storage**

👉 Example:

* Notes app
* Contacts
* To-do list
* Cache data

---

# 🧩 Core Concepts You MUST Know

## 1. Database

A container that holds tables.

```text
MyDatabase.db
```

---

## 2. Table

Structure to store data in rows & columns.

```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    name TEXT,
    age INTEGER
);
```

---

## 3. Row & Column

* **Row** → One record
* **Column** → Attribute

| id | name | age |
| -- | ---- | --- |
| 1  | John | 25  |

---

## 4. Data Types in SQLite

* INTEGER
* TEXT
* REAL (float)
* BLOB

---

## 5. Primary Key

Unique identifier

```sql
id INTEGER PRIMARY KEY AUTOINCREMENT
```

---

# ⚙️ Android SQLite Architecture

To use SQLite in Kotlin, you mainly work with:

## 1. `SQLiteOpenHelper`

This is the **main class** to manage DB.

You override:

### 🔹 `onCreate()`

Runs when DB is created

### 🔹 `onUpgrade()`

Runs when DB version changes

---

## 🧱 Basic Setup Example

```kotlin
class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "MyDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
}
```

---

# 🔁 CRUD Operations (MOST IMPORTANT)

You asked specifically about this — focus here 👇

---

# 🟢 1. CREATE (Insert Data)

```kotlin
val db = writableDatabase
val values = ContentValues()

values.put("name", "John")
values.put("age", 25)

db.insert("users", null, values)
```

---

# 🔵 2. READ (Fetch Data)

```kotlin
val db = readableDatabase
val cursor = db.rawQuery("SELECT * FROM users", null)

while (cursor.moveToNext()) {
    val id = cursor.getInt(0)
    val name = cursor.getString(1)
    val age = cursor.getInt(2)
}
cursor.close()
```

---

# 🟡 3. UPDATE

```kotlin
val db = writableDatabase
val values = ContentValues()

values.put("name", "Mike")

db.update("users", values, "id=?", arrayOf("1"))
```

---

# 🔴 4. DELETE

```kotlin
val db = writableDatabase
db.delete("users", "id=?", arrayOf("1"))
```

---

# ⚠️ Important Concepts for CRUD

## 1. `ContentValues`

Used to pass data (key-value pair)

---

## 2. `Cursor`

Used to read data from DB

* `moveToNext()`
* `getString()`, `getInt()`

---

## 3. `Readable vs Writable DB`

* `readableDatabase`
* `writableDatabase`

---

## 4. SQL Queries

You should know basic SQL:

* `SELECT`
* `INSERT`
* `UPDATE`
* `DELETE`
* `WHERE`

---

## 5. Closing Resources

Always close cursor:

```kotlin
cursor.close()
db.close()
```

---

# 🧠 Best Practices (IMPORTANT for real projects)

## ❌ Avoid raw SQLite directly in big apps

👉 Use modern library instead:

➡️ **Room Database (Jetpack)**

Why?

* Less boilerplate
* Compile-time checks
* Cleaner code

---

# 🔥 SQLite vs Room (Quick Truth)

| SQLite            | Room               |
| ----------------- | ------------------ |
| Manual queries    | Easy annotations   |
| More error-prone  | Safer              |
| Good for learning | Best for real apps |

---

# 🎯 What YOU Should Focus On (Based on your level)

Since you already built:

* Calculator ✅
* Gallery swipe ✅

👉 Next step:

### Learn these:

1. SQLite basics (you are here) ✅
2. CRUD implementation
3. Build project:

   * Notes app 📝
   * To-do list ✅

---

# 🚀 Mini Project Idea

👉 Build:
**Student Manager App**

Features:

* Add student
* View list
* Update student
* Delete student

---

# 💬 Final Advice

* Learn SQLite → for **concept clarity**
* Then switch to **Room (Jetpack)** → for real apps

---

