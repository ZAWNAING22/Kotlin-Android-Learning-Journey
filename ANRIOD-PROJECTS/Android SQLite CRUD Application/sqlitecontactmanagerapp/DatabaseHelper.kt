package com.example.sqlitecontactmanagerapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    companion object{
        private  const val DATABASE_NAME="ContactsDB"
        private  const val TABLE_NAME="contacts"
        private  const val COLUMN_ID="id"
        private  const val COLUMN_NAME="name"
        private  const val COLUMN_PHONE="phone"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery=("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_PHONE TEXT" +
                ")")
        db?.execSQL(createTableQuery)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery="DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)

    }



//    #function to insert data as Name and phone  ==  insertContacts → returns Long (row ID).
   fun insertContacts(name:String,phone:String):Long{
        val db=writableDatabase
        val values= ContentValues()
        values.put(COLUMN_NAME,name)
        values.put(COLUMN_PHONE,phone)
        val result=db.insert(TABLE_NAME,null,values)
        return result
    }

    // function to Read all user's Data  return as arrayList
    fun getAllContacts(): ArrayList<Contact>{
        val db=readableDatabase
        val list= ArrayList<Contact>()
        val cursor=db.rawQuery("SELECT * FROM $TABLE_NAME",null)
        if(cursor.moveToFirst()){
            do{
                list.add(Contact(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)))
            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list

    }

    // Function to update user and return true if updated===   updateContact → returns Int (rows updated).
    fun updateContact(id: Int,name: String,phone: String): Int{
        val db=writableDatabase
        val values= ContentValues()
        values.put(COLUMN_NAME,name)
        values.put(COLUMN_PHONE,phone)
        val result=db.update(TABLE_NAME,values,"$COLUMN_ID=?",arrayOf(id.toString()))
        return result

    }

    //Function to delete selected User ====  deleteContact → returns Int (rows deleted).
    fun deleteContact(id: Int): Int{
        val db=writableDatabase
        return db.delete(TABLE_NAME,"$COLUMN_ID=?",arrayOf(id.toString()))

    }



}