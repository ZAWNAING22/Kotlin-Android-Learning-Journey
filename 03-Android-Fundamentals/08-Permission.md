
## 1️⃣ **Runtime Permissions (Very Important 🔥)**

### What you learned:

Android apps must **ask user permission at runtime** for sensitive actions like calling.

### Where in your code:

```kotlin
ActivityCompat.checkSelfPermission(...)
ActivityCompat.requestPermissions(...)
```

### Flow:

1. Check permission
2. If granted → make call
3. If NOT → ask permission
4. Handle result in:

```kotlin
onRequestPermissionsResult()
```

### Key concept:

👉 Android security model (user controls access)

---

## 2️⃣ **Intent (Calling Feature)**

### What you learned:

Using **Intent to perform an action (make a phone call)**

### Code:

```kotlin
val callIntent = Intent(Intent.ACTION_CALL)
callIntent.data = Uri.parse("tel:$phoneNumber")
```

### Meaning:

* `Intent.ACTION_CALL` → tells Android to call
* `"tel:123456"` → phone number format

### Key concept:

👉 Intent = "ask Android system to do something"

---

## 3️⃣ **User Input Handling (EditText)**

### What you learned:

Getting input from user

```kotlin
phoneNumber = etPhoneNumber.text.toString()
```

### XML:

```xml
<EditText
    android:hint="enter phone number..."
    android:inputType="phone"/>
```

### Key concept:

👉 UI → Kotlin → Data flow

---

## 4️⃣ **Button Click Listener**

### What you learned:

Handling user interaction

```kotlin
ibCall.setOnClickListener {
    phoneNumber = etPhoneNumber.text.toString()
    if(phoneNumber.isNotEmpty())
        Call()
}
```

### Key concept:

👉 Event-driven programming (user action → code runs)

---

## 5️⃣ **Function Creation (Clean Code Practice)**

### What you learned:

Separating logic into a function

```kotlin
private fun Call()
```

Instead of writing everything inside `onCreate`

### Key concept:

👉 Code organization & reusability

---

## 6️⃣ **Android Manifest (Permissions)**

### What you learned:

Declaring permissions in manifest

```xml
<uses-permission android:name="android.permission.CALL_PHONE"/>
```

### Key concept:

👉 Manifest = app configuration file

---

## 7️⃣ **Options Menu (3-dot menu in app)**

### What you learned:

Creating menu in app

```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.option_menu, menu)
    return true
}
```

### Handling clicks:

```kotlin
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.item_Camara -> ...
        R.id.item_Share -> ...
        R.id.item_Exit -> System.exit(0)
    }
}
```

### Key concept:

👉 Adding menu actions in UI

---

## 8️⃣ **Toast Messages**

### What you learned:

Showing small messages

```kotlin
Toast.makeText(this, "Camera is selected", Toast.LENGTH_SHORT).show()
```

### Key concept:

👉 User feedback

---

## 9️⃣ **ConstraintLayout (UI Design)**

### What you learned:

Designing layout using constraints

```xml
app:layout_constraintTop_toTopOf="parent"
```

### Components used:

* `EditText`
* `ImageButton`

### Key concept:

👉 Flexible UI design

---

## 🔟 **Basic Validation**

```kotlin
if(phoneNumber.isNotEmpty())
```

### What you learned:

👉 Prevent empty input before action

---

# ⚡ Summary (Very Important)

Your Week 7 lecture covered:

| Topic            | Why Important              |
| ---------------- | -------------------------- |
| Intent           | Core Android communication |
| Permissions      | Security (VERY IMPORTANT)  |
| EditText         | User input                 |
| Button Click     | Interaction                |
| Manifest         | App configuration          |
| Menu             | UI features                |
| Toast            | Feedback                   |
| ConstraintLayout | UI design                  |

---

# 🧩 Big Picture

👉 This app teaches:

> “How to interact with Android system (call feature) safely using permissions”

---

# 🚀 What You Should Practice Next

Since you're learning Android seriously:

1. Replace `ACTION_CALL` with `ACTION_DIAL` (no permission needed)
2. Add validation (phone length check)
3. Show error if input is empty
4. Add second activity (navigation)

---
Good question — instead of many small topics, your lecture actually has **ONE main topic** 👇

---

# 🎯 **Main Topic: Android Intents + Runtime Permissions**

Everything in your code revolves around this:

> 👉 **“How an Android app performs system actions (like calling) safely using permissions”**

---

# 🧠 PART 1: **Intent (Core Concept)**

## 📌 What is Intent?

👉 Intent = a **message to Android system to do something**

---

## 📱 Types of Intent

### 1. Explicit Intent

* Move between your app screens
* Example: MainActivity → SecondActivity

---

### 2. Implicit Intent ⭐ (Used in your code)

* Ask Android to perform system action
* Example:

  * Call
  * Open camera
  * Open browser

---

## 📌 Your Example:

```kotlin
val callIntent = Intent(Intent.ACTION_CALL)
callIntent.data = Uri.parse("tel:$phoneNumber")
startActivity(callIntent)
```

### Meaning:

* `ACTION_CALL` → call someone
* `tel:` → phone number format

---

## ⚠️ Important:

👉 Some intents need permission (like CALL)

---

# 🔐 PART 2: Runtime Permissions (VERY IMPORTANT 🔥)

## 📌 What is Permission?

👉 User must allow app to use:

* Camera 📷
* Location 📍
* Call 📞

---

## 📌 Types:

| Type        | Example      |
| ----------- | ------------ |
| Normal      | Internet     |
| Dangerous ⭐ | Call, Camera |

---

## 📌 Flow (YOU MUST REMEMBER)

### Step 1: Declare in Manifest

```xml
<uses-permission android:name="android.permission.CALL_PHONE"/>
```

---

### Step 2: Check Permission

```kotlin
ActivityCompat.checkSelfPermission(...)
```

---

### Step 3: Request Permission

```kotlin
ActivityCompat.requestPermissions(...)
```

---

### Step 4: Handle Result

```kotlin
onRequestPermissionsResult()
```

---

## 📌 Your Flow in Simple Words:

1. User clicks call button
2. App checks permission
3. If allowed → CALL
4. If not → ask user
5. If user allows → CALL
6. If denied → show message

---

# 🔗 CONNECTION BETWEEN BOTH

👉 Intent + Permission work together

| Concept    | Role              |
| ---------- | ----------------- |
| Intent     | WHAT to do (call) |
| Permission | WHETHER allowed   |

---

# 🧾 SHORT EXAM NOTES (Write This 🔥)

## ✍️ Definition:

**Intent:**

> A messaging object used to request an action from another app component or system.

**Runtime Permission:**

> A security feature where the user grants permission during app usage.

---

## ✍️ Key Points:

* Intent is of 2 types:

  * Explicit
  * Implicit
* `ACTION_CALL` is implicit intent
* Dangerous permissions must be asked at runtime
* Permission flow:

  1. Declare
  2. Check
  3. Request
  4. Handle result

---

## ✍️ Important Functions:

* `startActivity()`
* `checkSelfPermission()`
* `requestPermissions()`
* `onRequestPermissionsResult()`

---

# 🧠 One-Line Memory Trick

👉
**Intent = Action**
**Permission = Approval**

---

# 🚀 What You MUST Understand Deeply

Focus on these 3:

1. 🔥 Intent (Explicit vs Implicit)
2. 🔥 Permission Flow (step by step)
3. 🔥 Why Android blocks dangerous actions


