package com.example.sqlitecontactmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name=findViewById<EditText>(R.id.etName)
        val phone=findViewById<EditText>(R.id.etPhone)
        val btnSave=findViewById<Button>(R.id.btnSave)

        val database= DatabaseHelper(this)

        btnSave.setOnClickListener {
            val contactName = name.text.toString()
            val contactPhone = phone.text.toString()

            if (contactName.isNotEmpty() && contactPhone.isNotEmpty()) {
                // Ensure this method name matches your DatabaseHelper
                database.insertContacts(contactName, contactPhone)
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show()

                // Return to MainActivity so the list can refresh
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}