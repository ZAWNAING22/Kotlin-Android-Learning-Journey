# Room Database in Jetpack — Complete Explanation

## What is Room?

**Room** is a local database library in Android used to store app data permanently.

It is part of:

* Android Jetpack
* built on top of SQLite

Room makes database work:

* easier
* safer
* less code-heavy

---

# Simple Definition

```text
Room = SQLite + Easy Kotlin APIs
```

Instead of writing raw SQL everywhere, Room lets you use:

* Kotlin classes
* annotations
* DAO interfaces

---

# Why Room is Used

Without Room:

* direct SQLite queries
* lots of boilerplate
* difficult maintenance

With Room:

* simple
* type-safe
* modern
* works well with Compose

---

# Real App Usage

| App          | Stored Data     |
| ------------ | --------------- |
| Notes App    | notes           |
| Chat App     | messages        |
| Shopping App | cart items      |
| Todo App     | tasks           |
| Offline App  | cached API data |

---

# Main Components of Room

Room has **3 major parts**:

| Component | Purpose              |
| --------- | -------------------- |
| Entity    | Table                |
| DAO       | Database operations  |
| Database  | Main database holder |

---

# Architecture Overview

```text
Entity → DAO → Database → UI/ViewModel
```

---

# 1. Entity (Table)

Entity represents a table in database.

Example:

```kotlin
@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,

    val age: Int
)
```

---

# Explanation

| Annotation     | Meaning        |
| -------------- | -------------- |
| `@Entity`      | Creates table  |
| `@PrimaryKey`  | Unique ID      |
| `autoGenerate` | Auto increment |

---

# Table Generated

```text
User Table
----------------
id | name | age
```

---

# 2. DAO (Data Access Object)

DAO contains database operations.

Examples:

* insert
* delete
* update
* get data

---

# Example DAO

```kotlin
@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>
}
```

---

# DAO Annotations

| Annotation | Purpose          |
| ---------- | ---------------- |
| `@Insert`  | Add data         |
| `@Delete`  | Remove data      |
| `@Update`  | Modify data      |
| `@Query`   | Custom SQL query |

---

# Why `suspend`?

Database operations should run in background threads.

So Room works well with:

* Kotlin Coroutines
* ViewModel
* Flow

---

# 3. Database Class

Main database holder.

```kotlin
@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
```

---

# Explanation

| Part           | Meaning          |
| -------------- | ---------------- |
| `entities`     | Tables           |
| `version`      | Database version |
| `RoomDatabase` | Base class       |

---

# Building the Database

Usually singleton.

```kotlin
val db = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "my_database"
).build()
```

---

# Complete Flow

```text
User clicks button
↓
ViewModel calls DAO
↓
DAO inserts into Room
↓
Room stores in SQLite
↓
UI updates automatically
```

---

# Room with MVVM

Most common architecture:

```text
Compose UI
↓
ViewModel
↓
Repository
↓
Room DAO
↓
SQLite Database
```

---

# Repository Layer

Repository manages data sources.

Example:

```kotlin
class UserRepository(
    private val dao: UserDao
) {

    fun getUsers() = dao.getAllUsers()

    suspend fun insert(user: User) {
        dao.insert(user)
    }
}
```

---

# ViewModel Example

```kotlin
class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val users = repository.getUsers()

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }
}
```

---

# Using Room in Compose

```kotlin
@Composable
fun UserScreen(viewModel: UserViewModel) {

    val users by viewModel.users.collectAsState(initial = emptyList())

    LazyColumn {

        items(users) { user ->

            Text(user.name)
        }
    }
}
```

---

# Dependencies

## Room

```kotlin
implementation("androidx.room:room-runtime:2.6.1")
ksp("androidx.room:room-compiler:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")
```

---

# KSP Plugin

```kotlin
plugins {
    id("com.google.devtools.ksp")
}
```

---

# Room + Flow

Room supports reactive updates.

```kotlin
@Query("SELECT * FROM User")
fun getUsers(): Flow<List<User>>
```

Whenever database changes:

* UI updates automatically

Very useful in Compose.

---

# Common Queries

## Insert

```kotlin
@Insert
suspend fun insert(user: User)
```

---

## Delete

```kotlin
@Delete
suspend fun delete(user: User)
```

---

## Update

```kotlin
@Update
suspend fun update(user: User)
```

---

## Select All

```kotlin
@Query("SELECT * FROM User")
fun getAll(): Flow<List<User>>
```

---

## Filter Query

```kotlin
@Query("SELECT * FROM User WHERE age > 18")
fun adults(): List<User>
```

---

# Relationships in Room

Room supports:

* One-to-One
* One-to-Many
* Many-to-Many

Example:

* User → Orders
* Student → Courses

Using:

* `@Relation`
* `@Embedded`

---

# Room vs SQLite

| SQLite           | Room                 |
| ---------------- | -------------------- |
| Manual SQL       | Easier APIs          |
| More boilerplate | Less code            |
| Error-prone      | Compile-time checks  |
| Hard maintenance | Cleaner architecture |

---

# Advantages of Room

| Advantage         | Explanation                 |
| ----------------- | --------------------------- |
| Type-safe         | compile-time query checking |
| Easy              | less boilerplate            |
| Coroutine support | suspend functions           |
| Flow support      | reactive UI                 |
| Compose-friendly  | automatic updates           |
| MVVM support      | clean architecture          |

---

# Limitations

| Limitation                 | Explanation          |
| -------------------------- | -------------------- |
| Local only                 | not cloud database   |
| SQL knowledge still needed | queries use SQL      |
| Complex migrations         | harder in large apps |

---

# Database Migration

When schema changes:

```kotlin
Room.databaseBuilder(...)
    .addMigrations(MIGRATION_1_2)
```

Used when:

* adding columns
* changing tables

---

# Important Concepts

## Entity = Table

```text
Class → Table
```

---

## Object = Row

```text
User("Ali", 20)
```

One row in table.

---

## DAO = Database Manager

Handles:

* insert
* update
* delete
* query

---

## RoomDatabase = Database Container

Connects all DAOs and entities.

---

# Most Important Things to Learn First

## Beginner

* Entity
* DAO
* Database
* Insert
* Query

## Intermediate

* Flow
* Repository
* ViewModel
* MVVM

## Advanced

* Relations
* Migration
* Paging
* Offline caching

---

# Simple Mental Model

```text
Entity → table
DAO → operations
Database → connection
Repository → data manager
ViewModel → UI logic
Compose → display data
```

---

# Typical Interview/Exam Questions

## What is Room?

SQLite abstraction library in Android Jetpack.

---

## Why use Room instead of SQLite?

* less boilerplate
* compile-time checking
* coroutine support

---

## What are Room components?

* Entity
* DAO
* Database

---

## What is DAO?

Interface containing database operations.

---

## Why use Flow with Room?

Automatic UI updates when database changes.
