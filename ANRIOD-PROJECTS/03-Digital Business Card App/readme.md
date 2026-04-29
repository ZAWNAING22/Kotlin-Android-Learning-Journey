# 💼 Digital Business Card App (Jetpack Compose)

A modern Android application built with **Kotlin** and **Jetpack Compose** that replaces a traditional paper business card with an elegant **digital business card**.

This project demonstrates **Jetpack Compose layouts, buttons, images, rows, columns, styling, and Toast messages** while building a clean professional UI.

---

## 🚀 Features

📷 Display profile photo
👤 Show full name
💼 Profession / Job title
📞 Contact details (phone, email, etc.)
🎨 Gray background card layout
📱 Fully built using **Jetpack Compose**
🔘 Custom "Get in Touch" button
✨ Rounded corners + custom colors
📢 Toast message on button click

---

## 🧩 UI Components Used

| Item          | Component    |
| ------------- | ------------ |
| Profile Photo | `Image`      |
| Full Name     | `Text`       |
| Profession    | `Text`       |
| Contact Info  | `Row + Text` |
| Main Layout   | `Column`     |
| Action Button | `Button`     |

---

## 🎨 Layout Structure

All components are arranged vertically using a **Column**.

```mermaid id="8w6jfp"
flowchart TD
    A[Screen Background 📱] --> B[Gray Column Container]
    B --> C[Profile Image 📷]
    B --> D[Full Name 👤]
    B --> E[Profession 💼]
    B --> F[Phone Row 📞]
    B --> G[Email Row 📧]
    B --> H[Get in Touch Button 🔘]
```

---

## 📱 Example UI Preview

![Image](https://images.openai.com/static-rsc-4/94Od0yzov7cf6fX4cbNrXNpsVgSyggWjPICOrcMt-5xsgxuFKtEI27wy85cGQJHQEKQbXANSroqHT6B2rmmXQ_TOaIaocfHjZzECgros01bxJD8lLewNx1zep_vuzr7vT_KRsM4iueLyR59FZJedMt1b7dvNMTj0S9PfITLrR8kpB_01_3nUXvRJi3JI2bk5?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/jjzHl-YBCTRmIy6GBu6Syg5Zgq82OFuNSWxqhTxu3CHoE_B60xPGl_TXU4eMvZHAk5XoJAwvdm4ediZ3gwAiaAPZifeF2Xm7r5mYlOy_PtdE9w1d8pir1hVSK35S5ud4zFqmlRYhABI82ki0Iwy5OTs3joo1c6xzI4yB8P8j8J5o1nE-aJUrnkKXp97lm2EJ?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/jTE8EYQXTLe2i2MY68TYOKJLG8_evvilAHBpSb3jBJ_jf_TKo-GuYGGhLdDJ3-gl_gBssCAzPm7QegpIIwNDbaOnYiAYTd8izSY2yjCRUYLis43JdlEQYQ-QZ-QRzYBG3NM0YhZCick8MQsmo1pXyd-3qVTHjPYjOqXIkraoEwC2JVlMjHWBXdGgYHH5jkPl?purpose=fullsize)

---

## 📌 Functional Requirements

### 📷 Profile Section

* Show profile image using `Image`
* Circular or rounded style recommended

### 👤 Identity Section

* Full name using bold `Text`
* Profession / title below the name

### 📞 Contact Section

Each contact line uses a **Row** with two `Text` elements:

```plaintext
Phone:   +90 555 123 4567
Email:   yourname@email.com
```

### 🔘 Get in Touch Button

* Displays **Toast message**
* Custom button color using `ButtonDefaults`
* Rounded corners using `RoundedCornerShape`

---

## 🛠️ Tech Stack

* **Language:** Kotlin 🧩
* **UI Toolkit:** Jetpack Compose 🎨
* **IDE:** Android Studio 🤖
* **Design:** Material 3 ✨

---

## 📁 Project Structure

```plaintext
com.example.businesscardapp
│
├── MainActivity.kt
├── ui/theme/
│
├── res/drawable/
│   └── profile.jpg
```

---

## 🔄 App Workflow

```mermaid id="r2e8nz"
sequenceDiagram
    participant User
    participant App
    participant UI

    User->>App: Open App
    App->>UI: Load Business Card
    User->>UI: Tap Get in Touch
    UI-->>User: Show Toast Message
```

---

## 🎯 Learning Outcomes

This project helps you learn:

* Jetpack Compose `Column`
* Jetpack Compose `Row`
* `Text`, `Image`, `Button`
* Styling components
* Custom button shapes
* Toast messages in Compose
* UI alignment & spacing

---

## 📌 Future Improvements

* 🌙 Dark mode support
* 🌐 Clickable social media links
* 📷 Camera profile upload
* 🎞️ Animations with Compose
* 💾 Save contact as vCard

---

