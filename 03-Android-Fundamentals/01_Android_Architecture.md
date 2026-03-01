

# 📱 Android Architecture Basics

## 1️⃣ What is Android?

Android is an operating system developed by Google for mobile devices.

Android apps are written mainly in **Kotlin** or Java and run on the **Android Runtime (ART)**.

An Android app is packaged as an:

> **APK (Android Package)**

---

## 2️⃣ How Android Apps Work

When you install an app:

* It runs inside its own **process**
* It has its own **memory space**
* It is sandboxed (isolated from other apps)

Each app contains components like:

* **Activity** → UI screen
* **Service** → Background work
* **BroadcastReceiver** → Listens for system events
* **ContentProvider** → Data sharing

For beginners, we focus mostly on:

> ✅ Activity (because it's the entry point of UI)

---

## 3️⃣ Project Structure in Android Studio

When you create a project in Android Studio, you will see:

```
app/
 ├── manifests/
 ├── java/ (or kotlin/)
 ├── res/
 └── Gradle Scripts
```

### 📂 manifests/

Contains:

* `AndroidManifest.xml`
* Declares activities
* App permissions
* App entry point

---

### 📂 java/ or kotlin/

Contains:

* Your source code
* Activities
* ViewModels
* Repository classes

---

### 📂 res/

Contains:

* Layouts (UI)
* Images
* Strings
* Colors
* Themes

---

### ⚙ Gradle Scripts

Used for:

* Managing dependencies
* Adding libraries
* Configuring SDK versions

Example dependency:

```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
```

---

## 4️⃣ What is AndroidManifest.xml?

This file tells Android:

* What activities exist
* Which one starts first
* What permissions app needs

Example:

```xml
<application>
    <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity>
</application>
```

This makes `MainActivity` the entry screen.

---

## 5️⃣ What Happens When App Starts?

1. User taps app icon
2. Android OS creates a process
3. Main Activity is launched
4. `onCreate()` is called

This is where your UI is initialized.

---

## 6️⃣ Why Architecture Matters?

Without architecture:

* Code becomes messy
* Hard to maintain
* Hard to scale

Modern Android development uses:

* MVVM pattern
* ViewModel
* Repository
* Coroutines + Flow

You will learn these next.

---

## 🧠 Key Concepts Learned

* What Android is
* App components
* Project structure
* Manifest file
* App startup flow

---

# 🏁 Summary

Android apps:

* Run in isolated processes
* Start from an Activity
* Are configured in Manifest
* Use Gradle for dependencies

This is the foundation before learning Activity lifecycle.

---

