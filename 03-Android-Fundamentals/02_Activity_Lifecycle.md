
---

# 📱 Activity Lifecycle in Android

## 1️⃣ What is an Activity?

An **Activity** represents a single screen in an Android app.

Example:

* Login screen
* Home screen
* Settings screen

Every Android app starts with an Activity declared in the `AndroidManifest.xml`.

---

## 2️⃣ Why Lifecycle Exists?

Mobile apps are different from desktop apps.

Your app can be:

* Opened
* Minimized
* Rotated
* Covered by another app
* Destroyed to free memory

Android must manage memory efficiently.

So Android controls Activity states using the **Lifecycle system**.

---

## 3️⃣ Lifecycle States

An Activity moves between these states:

```
Created → Started → Resumed → Paused → Stopped → Destroyed
```

---

## 4️⃣ Lifecycle Methods Explained

### 🔹 onCreate()

Called when activity is first created.

Used for:

* Initializing UI
* Setting layout
* Initial setup

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
}
```

---

### 🔹 onStart()

Activity becomes visible to user.

---

### 🔹 onResume()

Activity is now in foreground and user can interact.

This is the **active state**.

---

### 🔹 onPause()

Activity partially visible (another app or dialog on top).

Used to:

* Pause animations
* Save temporary state

---

### 🔹 onStop()

Activity no longer visible.

---

### 🔹 onDestroy()

Activity is destroyed.

Called when:

* User finishes activity
* System removes it from memory

---

## 5️⃣ Lifecycle Flow Example

If user:

### ▶ Opens app:

```
onCreate()
onStart()
onResume()
```

---

### 🔄 Presses Home button:

```
onPause()
onStop()
```

---

### 🔙 Returns to app:

```
onRestart()
onStart()
onResume()
```

---

### ❌ Closes app:

```
onPause()
onStop()
onDestroy()
```

---

## 6️⃣ Real Demo Practice (You Should Build This)

Create an app that logs lifecycle events:

```kotlin
override fun onStart() {
    super.onStart()
    Log.d("Lifecycle", "onStart called")
}
```

Rotate the device and observe logs.

You will see:

* Activity destroyed
* Activity recreated

This teaches why ViewModel is important.

---

## 7️⃣ Common Beginner Mistakes

❌ Doing heavy work in onCreate
❌ Starting network calls without lifecycle awareness
❌ Ignoring configuration changes (rotation)
❌ Not saving state

---

## 8️⃣ Why Lifecycle is Important for Modern Android

Modern Android uses lifecycle-aware components from:

Android Jetpack

Examples:

* ViewModel
* LiveData
* LifecycleOwner
* lifecycleScope

These prevent:

* Memory leaks
* Crashes
* Unnecessary background work

---

## 🧠 Key Concepts Learned

* What an Activity is
* Lifecycle states
* Lifecycle methods
* App behavior when minimized or rotated
* Why lifecycle awareness matters

---
![
Android Activity Lifecycle with Callback Methods & Usage - DataFlair](https://tse4.mm.bing.net/th/id/OIP.bMg2YbZZ9pzVyjLSinHAMAHaI1?rs=1&pid=ImgDetMain&o=7&rm=3)

---

# 🏁 Summary

An Activity:

* Represents a screen
* Is controlled by Android lifecycle
* Can be created, paused, stopped, destroyed
* Must handle state changes properly

Understanding lifecycle is critical before learning ViewModel.

---


