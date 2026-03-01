

# 📱 Context and Intent in Android

## 1️⃣ What is Context?

In Android, **Context** gives access to:

* App resources
* System services
* Starting activities
* Accessing files
* Showing Toast messages

Think of Context as:

> 🔑 The bridge between your app and the Android system.

Every Activity is a Context.

---

## 2️⃣ Types of Context

### 🔹 Application Context

* Lives as long as app lives
* Use for global operations

```kotlin
applicationContext
```

---

### 🔹 Activity Context

* Tied to Activity lifecycle
* Used for UI-related operations

```kotlin
this
```

---

## 3️⃣ Why Context Matters

Example: Showing a Toast

```kotlin
Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
```

Without Context → Android doesn’t know where to display it.

---

## 4️⃣ What is an Intent?

An **Intent** is a messaging object used to:

* Start another Activity
* Start a Service
* Send data between components

It tells Android:

> “I want to do this action.”

---

## 5️⃣ Types of Intent

### 🔹 Explicit Intent

Used to open a specific Activity inside your app.

Example:

```kotlin
val intent = Intent(this, SecondActivity::class.java)
startActivity(intent)
```

Used for:

* Navigation between screens

---

### 🔹 Implicit Intent

Used to request an action from another app.

Example: Open browser

```kotlin
val intent = Intent(Intent.ACTION_VIEW)
intent.data = Uri.parse("https://www.google.com")
startActivity(intent)
```

Android finds the best app to handle the action.

---

## 6️⃣ Passing Data Between Activities

You can attach extra data to an Intent.

### 🔹 Sending Data

```kotlin
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("username", "John")
startActivity(intent)
```

---

### 🔹 Receiving Data

```kotlin
val name = intent.getStringExtra("username")
```

---

## 7️⃣ Real Practice You Should Build

Create:

### 🧱 Two Screen App

Screen 1:

* EditText
* Button

When button clicked:

* Send text to Screen 2

Screen 2:

* Display received text

This builds real understanding.

---

## 8️⃣ Common Beginner Mistakes

❌ Using Activity context in long-lived objects
❌ Memory leaks from wrong context usage
❌ Forgetting to declare Activity in `AndroidManifest.xml`
❌ Null crashes when reading extras

---

## 9️⃣ Modern Navigation

In modern Android apps using:

Android Jetpack

Navigation is handled by:

* Navigation Component
* Compose Navigation

But understanding Intent is foundational.

---

## 🧠 Key Concepts Learned

* What Context is
* Activity vs Application context
* What Intent is
* Explicit vs Implicit Intent
* Passing data between screens

---

# 🏁 Summary

Context:

* Connects app to Android system

Intent:

* Allows communication between components

Understanding these two is required before learning:

* Fragments
* Navigation Component
* ViewModel communication

---


(2026 recommendation is Compose, but I’ll follow your choice.)
