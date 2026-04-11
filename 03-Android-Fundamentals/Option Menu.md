In Android (Kotlin/XML), an **Option Menu** is the menu that appears in the **top app bar (toolbar)**—usually when you tap the **three dots (⋮)** or directly as icons.

---

# 🔹 What is Option Menu?

An **Option Menu** is used to provide **main actions of your app or screen**.

👉 It is **global to the Activity** (not tied to a specific button or view).

---

# 🔹 Where is it used?

You see Option Menus in many apps:

* Email app → “Compose”, “Settings”
* WhatsApp → “New chat”, “Settings”, “Linked devices”
* Gallery app → “Sort”, “Delete”, “Share”

📍 Location:

* Top-right corner of the screen (toolbar/action bar)

---

# 🔹 When should you use it?

Use Option Menu when:

### ✅ 1. You have important app-level actions

Example:

* Add new contact
* Save data
* Settings
* Exit

---

### ✅ 2. Actions are not tied to a specific UI element

Example:

* “Logout” (not tied to a button)
* “Sort list”

---

### ✅ 3. You want consistent UI (Android standard design)

Android recommends:

* Frequent actions → show as icons
* Less used → inside 3-dot menu

---

# 🔹 Example from your project (SQLite Contact App)

You mentioned:

> New Contact, Update Contact, Exit

👉 Perfect use of Option Menu:

* ➕ New Contact → Add data to SQLite
* ✏️ Update Contact → Modify data
* ❌ Exit → Close app

---

# 🔹 How it works (Concept Flow)

1. Create menu XML (`res/menu/menu_main.xml`)
2. Inflate menu in Activity
3. Handle clicks

---

# 🔹 Basic Code Example

### 1. Menu XML

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/new_contact"
        android:title="New Contact" />

    <item
        android:id="@+id/update_contact"
        android:title="Update Contact" />

    <item
        android:id="@+id/exit"
        android:title="Exit" />
</menu>
```
---

```xml
<!-- App bar container -->
<com.google.android.material.appbar.AppBarLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

    <!-- Toolbar inside AppBarLayout -->
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
</com.google.android.material.appbar.AppBarLayout>
```

---

### 📝 Key Notes
- **`AppBarLayout`** → parent container, gives Material Design scrolling/elevation behavior.
- **`Toolbar`** → actual action bar widget, flexible placement.
- Use **`match_parent` width** so it spans the screen.
- Use **`?attr/actionBarSize`** for height → automatically adapts to system-defined action bar size.
- `android:theme` and `app:popupTheme` let you control colors for the toolbar and its overflow menu.

---

### ⚡ Typical usage in Activity
```kotlin
val toolBar = findViewById<Toolbar>(R.id.toolbar)
setSupportActionBar(toolBar)
supportActionBar?.title = "My App"
```

This way, your toolbar behaves like a proper ActionBar and integrates with menus, navigation, and Material Design patterns.
---

### 2. Show Menu in Activity

```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
}
```

---

### 3. Handle Clicks

```kotlin
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.new_contact -> {
            Toast.makeText(this, "New Contact", Toast.LENGTH_SHORT).show()
        }
        R.id.update_contact -> {
            Toast.makeText(this, "Update Contact", Toast.LENGTH_SHORT).show()
        }
        R.id.exit -> {
            finish()
        }
    }
    return true
}
```

---

# 🔹 Key Points (Exam / Interview)

* Option Menu = **Activity-level menu**
* Appears in **Toolbar / ActionBar**
* Used for **main actions**
* Defined in **menu XML**
* Handled using `onOptionsItemSelected()`

---

# 🔹 Option Menu vs Context Menu (Important)

| Feature  | Option Menu    | Context Menu          |
| -------- | -------------- | --------------------- |
| Scope    | Whole Activity | Specific View         |
| Trigger  | Toolbar        | Long press            |
| Use case | Main actions   | Item-specific actions |

---

# 🔹 Simple Memory Trick

👉 **Option Menu = "What can I do in this screen?"**

---
