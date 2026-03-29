

# 🔐 What are Permissions in Android?

**Permissions** are rules that control what your app is allowed to do on a user’s device.

👉 Example:

* Access camera 📷
* Read contacts 👤
* Use internet 🌐
* Get location 📍

Android does this to **protect user privacy and security**.

---

# 📂 Types of Permissions

## 1. Normal Permissions

* Low risk
* Automatically granted by system

✅ Examples:

* Internet access
* Set wallpaper

👉 You only declare them in **AndroidManifest.xml**

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

## 2. Dangerous Permissions

* High risk (access personal data)
* Must ask user at runtime

✅ Examples:

* Camera
* Location
* Storage
* Contacts

---

# ⚙️ Steps to Use Permissions (Important!)

## Step 1: Declare in Manifest

```xml
<uses-permission android:name="android.permission.CAMERA"/>
```

---

## Step 2: Check Permission in Kotlin

```kotlin
if (checkSelfPermission(android.Manifest.permission.CAMERA) 
    == PackageManager.PERMISSION_GRANTED) {

    // Permission already granted
} else {
    requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 1)
}
```

---

## Step 3: Handle User Response

```kotlin
override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray
) {
    if (requestCode == 1) {
        if (grantResults.isNotEmpty() && 
            grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // Permission granted
        } else {
            // Permission denied
        }
    }
}
```

---

# 🧠 Easy Concept Summary

Think like this:

👉 App wants access →
👉 Android asks user →
👉 User allows/denies →
👉 App acts accordingly

---

# ⭐ Modern (Better) Way – Activity Result API

Instead of old method, use this:

```kotlin
val requestPermissionLauncher = 
    registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            // Permission granted
        } else {
            // Permission denied
        }
    }

// Launch permission request
requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
```

---

# 🚨 Important Tips

* Always explain **why** you need permission (better UX)
* Don’t ask all permissions at once ❌
* Handle **denied case properly**
* Some permissions can be **permanently denied**

---

# 📌 What You Should Know (Exam / Interview)

✔ Difference between normal & dangerous permission
✔ Manifest vs Runtime permission
✔ How to request permission in Kotlin
✔ How to handle result
✔ New Activity Result API

---


