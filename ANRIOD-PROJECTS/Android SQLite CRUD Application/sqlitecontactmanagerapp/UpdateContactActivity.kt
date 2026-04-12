package com.example.sqlitecontactmanagerapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpdateContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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