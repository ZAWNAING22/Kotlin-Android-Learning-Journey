package com.example.sqlitecontactmanagerapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URI
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseHelper
    lateinit var listView: ListView
    lateinit var contacts: ArrayList<Contact>
    var selectedContact: Contact?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database= DatabaseHelper(this)
        listView=findViewById(R.id.listView)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        loadContacts()
        listView.setOnItemClickListener { _, _, position, _ ->
            selectedContact = contacts[position]
            Toast.makeText(this, "Selected: ${selectedContact!!.name}", Toast.LENGTH_SHORT).show()
        }


    }
    private fun loadContacts() {
        contacts = database.getAllContacts()
        val names = contacts.map { it.name }
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add -> {
                Toast.makeText(this, "testing", Toast.LENGTH_SHORT).show()
                val intent=Intent(this, AddContactActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_update -> { // Correctly handles Update Contact [cite: 8, 13]
                selectedContact?.let {
                    val intent = Intent(this, UpdateContactActivity::class.java)
                    intent.putExtra("id", it.id)
                    intent.putExtra("name", it.name)
                    intent.putExtra("phone", it.phone)
                    startActivity(intent)
                } ?: Toast.makeText(this, "Select a contact first", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_delete -> { // Changed from menu_update to menu_delete
                selectedContact?.let {
                    database.deleteContact(it.id)
                    loadContacts()
                    selectedContact = null // Clear selection after delete
                } ?: Toast.makeText(this, "Select a contact first", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_call -> { // Handles Call requirement [cite: 10, 15]
                selectedContact?.let {
                    callContact(it.phone)
                } ?: Toast.makeText(this, "Select a contact first", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_exit -> finish() // Handles Exit requirement [cite: 7, 12]
        }
        return true
    }
    private fun callContact(phone: String) {
        val callIntent = Intent(Intent.ACTION_CALL) // Use local variable
        callIntent.data = Uri.parse("tel:$phone")

        // Check permission using Android Manifest
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
        } else
        {
            startActivity(callIntent)
        }
    }
    override fun onResume() {
        super.onResume()
        loadContacts()
    }
}