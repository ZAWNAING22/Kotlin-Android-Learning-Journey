 a **complete working structure + Kotlin code** for your SQLite Contact Manager app.

---

# 📁 Project Structure

```
com.example.contactapp
│
├── MainActivity.kt
├── AddContactActivity.kt
├── UpdateContactActivity.kt
├── DatabaseHelper.kt
├── Contact.kt
│
├── res/layout/
│   ├── activity_main.xml
│   ├── activity_add_contact.xml
│   ├── activity_update_contact.xml
│   ├── list_item.xml
│
├── res/menu/
│   └── menu_main.xml
```

---

# 🗄️ 1. DatabaseHelper.kt

```kotlin
package com.example.contactapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "ContactsDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE contacts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "phone TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS contacts")
        onCreate(db)
    }

    fun insertContact(name: String, phone: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("phone", phone)
        db.insert("contacts", null, values)
    }

    fun getAllContacts(): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM contacts", null)

        while (cursor.moveToNext()) {
            list.add(
                Contact(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
                )
            )
        }
        cursor.close()
        return list
    }

    fun updateContact(id: Int, name: String, phone: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("phone", phone)
        db.update("contacts", values, "id=?", arrayOf(id.toString()))
    }

    fun deleteContact(id: Int) {
        val db = writableDatabase
        db.delete("contacts", "id=?", arrayOf(id.toString()))
    }
}
```

---

# 📦 2. Contact.kt (Model)

```kotlin
package com.example.contactapp

data class Contact(
    val id: Int,
    val name: String,
    val phone: String
)
```

---

# 🏠 3. MainActivity.kt

```kotlin
package com.example.contactapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    lateinit var db: DatabaseHelper
    lateinit var listView: ListView
    lateinit var contacts: ArrayList<Contact>
    var selectedContact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)
        listView = findViewById(R.id.listView)

        loadContacts()

        listView.setOnItemClickListener { _, _, position, _ ->
            selectedContact = contacts[position]
            Toast.makeText(this, "Selected: ${selectedContact!!.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadContacts() {
        contacts = db.getAllContacts()
        val names = contacts.map { it.name }
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_add -> {
                startActivity(Intent(this, AddContactActivity::class.java))
            }

            R.id.menu_update -> {
                selectedContact?.let {
                    val intent = Intent(this, UpdateContactActivity::class.java)
                    intent.putExtra("id", it.id)
                    intent.putExtra("name", it.name)
                    intent.putExtra("phone", it.phone)
                    startActivity(intent)
                }
            }

            R.id.menu_delete -> {
                selectedContact?.let {
                    db.deleteContact(it.id)
                    loadContacts()
                }
            }

            R.id.menu_call -> {
                selectedContact?.let {
                    callContact(it.phone)
                }
            }

            R.id.menu_exit -> finish()
        }
        return true
    }

    private fun callContact(phone: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phone")

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            return
        }
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        loadContacts()
    }
}
```

---

# ➕ 4. AddContactActivity.kt

```kotlin
package com.example.contactapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val name = findViewById<EditText>(R.id.etName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val db = DatabaseHelper(this)

        btnSave.setOnClickListener {
            db.insertContact(name.text.toString(), phone.text.toString())
            finish()
        }
    }
}
```

---

# ✏️ 5. UpdateContactActivity.kt

```kotlin
package com.example.contactapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class UpdateContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_contact)

        val name = findViewById<EditText>(R.id.etName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)

        val id = intent.getIntExtra("id", -1)
        name.setText(intent.getStringExtra("name"))
        phone.setText(intent.getStringExtra("phone"))

        val db = DatabaseHelper(this)

        btnUpdate.setOnClickListener {
            db.updateContact(id, name.text.toString(), phone.text.toString())
            finish()
        }
    }
}
```

---

# 📋 6. menu_main.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/menu_add" android:title="New Contact"/>
    <item android:id="@+id/menu_update" android:title="Update Contact"/>
    <item android:id="@+id/menu_delete" android:title="Delete Contact"/>
    <item android:id="@+id/menu_call" android:title="Call"/>
    <item android:id="@+id/menu_exit" android:title="Exit"/>
</menu>
```

---

# 📱 7. activity_main.xml

```xml
<ListView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

# ➕ 8. activity_add_contact.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText android:id="@+id/etName" android:hint="Name"/>
    <EditText android:id="@+id/etPhone" android:hint="Phone"/>

    <Button
        android:id="@+id/btnSave"
        android:text="Save"/>
</LinearLayout>
```

---

# ✏️ 9. activity_update_contact.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText android:id="@+id/etName"/>
    <EditText android:id="@+id/etPhone"/>

    <Button
        android:id="@+id/btnUpdate"
        android:text="Update"/>
</LinearLayout>
```

---

# ⚠️ 10. AndroidManifest.xml Permission

```xml
<uses-permission android:name="android.permission.CALL_PHONE"/>
```

---




