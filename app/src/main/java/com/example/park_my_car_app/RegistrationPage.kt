package com.example.park_my_car_app

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegistrationPage : AppCompatActivity() {

    lateinit var fullnameField: EditText
    lateinit var usernameField: EditText
    lateinit var phoneField: EditText
    lateinit var emailField: EditText
    lateinit var passwordField: EditText
    lateinit var db: SQLiteDatabase
    var DBNAME = "ParkMyCar"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        fullnameField = findViewById(R.id.vehicleBook)
        usernameField = findViewById(R.id.modelBook)
        phoneField = findViewById(R.id.startingDataBook)
        emailField = findViewById(R.id.endingDataBook)
        passwordField = findViewById(R.id.slotBook)

        db = openOrCreateDatabase(DBNAME, MODE_PRIVATE, null)
//
        val tableQuery =
            "CREATE TABLE IF NOT EXISTS users(id Integer PRIMARY KEY AUTOINCREMENT, fullname TEXT, username TEXT, phone TEXT, email TEXT, password  TEXT)"

        db.execSQL(tableQuery)


    }

    fun onRegister(view: View) {
        insertData(
            fullnameField.text.toString(),
            usernameField.text.toString(),
            phoneField.text.toString(),
            emailField.text.toString(),
            passwordField.text.toString()
        )
        Toast.makeText(this,"You have been registered",Toast.LENGTH_LONG)
    }

    fun insertData(
        fullname: String,
        username: String,
        phone: String,
        email: String,
        password: String
    ) {
        val cv = ContentValues()
        cv.put("fullname", fullname)
        cv.put("username", username)
        cv.put("phone", phone)
        cv.put("email", email)
        cv.put("password", password)

        db.insert("users", null, cv)
        db.close()
        finish()

    }
}
