## What is Firebase Cloud Messaging (FCM)?

Google FCM is a **free push notification service** from [Firebase](https://firebase.google.com?utm_source=chatgpt.com).

It lets your backend (Python server) send messages to Android apps, such as:

* New alert notifications
* Chat messages
* System warnings
* Real-time updates
* AI attack alerts (good for your AI Network Monitor project)

Example:

> Your Python backend detects a DDoS attack → sends notification → Android app instantly receives alert.

---

# FCM Architecture

```text
Python Backend
      ↓
Firebase Cloud Messaging Server
      ↓
Android App (Kotlin)
      ↓
Notification appears on phone
```

---

# Important Terms

## 1. Firebase Project

A project created in Firebase Console.

Example:

* AI Network Monitor
* Chat App
* Weather App

---

# 2. google-services.json

This is a configuration file for Android.

It connects your Android app with Firebase.

You download it from Firebase Console and place it inside:

```text
app/google-services.json
```

It contains:

* Firebase project ID
* API keys
* App configuration
* Sender ID

Example:

```json
{
  "project_info": {
    "project_number": "123456789",
    "project_id": "ai-monitor"
  }
}
```

You NEVER write this manually.

Firebase generates it automatically.

---

# 3. Server Key / API Key

This key allows your backend server (Python) to send notifications through Firebase.

Old system:

* Server Key

New modern system:

* Service Account JSON (recommended)

---

# 4. Service Account JSON

This is the secure credential file used by backend servers.

Example filename:

```text
firebase-adminsdk.json
```

Used in:

* Python
* Node.js
* Java backend

It allows:

* Sending notifications
* Accessing Firebase services
* Admin operations

---

# Difference Between google-services.json and Service Account JSON

| File                 | Used For               | Put Where                 |
| -------------------- | ---------------------- | ------------------------- |
| google-services.json | Android app config     | Android Studio app folder |
| service-account.json | Backend authentication | Python backend/server     |

---

# How to Create Firebase Account & Project

## Step 1 — Open Firebase

Go to:

[Firebase Console](https://console.firebase.google.com?utm_source=chatgpt.com)

Login with your Google account.

---

# Step 2 — Create Project

Click:

```text
Create Project
```

Example:

```text
AI Network Monitor
```

Disable Google Analytics if unnecessary.

---

# Step 3 — Add Android App

Click Android icon.

Enter:

## Package Name

Example:

```text
com.zaw.ainetworkmonitor
```

VERY IMPORTANT:
Must match your Android app package exactly.

---

# Step 4 — Download google-services.json

Firebase gives you:

```text
google-services.json
```

Put it inside:

```text
app/google-services.json
```

---

# Step 5 — Enable Cloud Messaging

In Firebase Console:

```text
Project Settings
→ Cloud Messaging
```

FCM is already enabled automatically.

---

# Android Kotlin Setup

---

# 1. Add Dependencies

In `build.gradle.kts (app)`:

```kotlin
dependencies {

    implementation("com.google.firebase:firebase-messaging:24.0.0")

}
```

---

# 2. Add Google Services Plugin

In project-level `build.gradle.kts`:

```kotlin
plugins {
    id("com.google.gms.google-services") version "4.4.2" apply false
}
```

In app-level:

```kotlin
plugins {
    id("com.google.gms.google-services")
}
```

---

# 3. Sync Project

Click:

```text
Sync Now
```

---

# 4. Create FCM Service

```kotlin
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Log.d("FCM", "Message: ${message.notification?.body}")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Log.d("FCM_TOKEN", token)
    }
}
```

---

# 5. Add Service in AndroidManifest.xml

```xml
<service
    android:name=".MyFirebaseMessagingService"
    android:exported="false">

    <intent-filter>
        <action android:name="com.google.firebase.MESSAGING_EVENT"/>
    </intent-filter>

</service>
```

---

# 6. Get Device Token

FCM gives every device a unique token.

```kotlin
FirebaseMessaging.getInstance().token
    .addOnCompleteListener {
        if (it.isSuccessful) {

            val token = it.result

            Log.d("TOKEN", token)
        }
    }
```

Your Python backend sends notifications to this token.

---

# Python Backend Setup

Install Firebase Admin SDK:

```bash
pip install firebase-admin
```

---

# Download Service Account JSON

Firebase Console:

```text
Project Settings
→ Service Accounts
→ Generate New Private Key
```

Download:

```text
service-account.json
```

Put it in Python project.

---

# Python Send Notification Example

```python
import firebase_admin
from firebase_admin import credentials, messaging

# Load service account
cred = credentials.Certificate("service-account.json")

firebase_admin.initialize_app(cred)

# Device token from Android app
token = "DEVICE_TOKEN"

# Create notification
message = messaging.Message(
    notification=messaging.Notification(
        title="AI Alert",
        body="DDoS attack detected!"
    ),
    token=token
)

# Send notification
response = messaging.send(message)

print("Sent:", response)
```

---

# Full Flow for Your AI Network Monitor

```text
ML Model detects attack
        ↓
Flask API triggers FCM
        ↓
Firebase sends push notification
        ↓
Android app receives alert
        ↓
User sees notification instantly
```

This is how professional monitoring systems work.

---

# Typical Real-World Usage

| App Type         | FCM Usage               |
| ---------------- | ----------------------- |
| Banking Apps     | Fraud alerts            |
| Chat Apps        | New messages            |
| Food Delivery    | Order updates           |
| Security Systems | Threat alerts           |
| Your AI Monitor  | Attack detection alerts |

---

# Security Important

Never upload:

* service-account.json
* API keys

to:

* GitHub
* public repositories

Add to `.gitignore`:

```text
google-services.json
service-account.json
```

---

# Recommended Learning Order For You

Since your roadmap includes Firebase and Android: 

Learn in this order:

1. Firebase basics
2. Authentication
3. Firestore
4. FCM notifications
5. Real-time updates
6. Backend integration with Flask

---

# Modern Production Architecture

```text
Android Kotlin App
       ↕
Firebase
       ↕
Python Flask Backend
       ↕
ML Model
```

This architecture is very common in:

* AI systems
* monitoring apps
* IoT systems
* real-time applications
