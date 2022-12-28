package com.example.park_my_car_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onLogin(view : View){
        var loginIntent : Intent = Intent(this,LoginPage::class.java)
        startActivity(loginIntent)
    }

    fun onRegister(view : View){
        var registerIntent = Intent(this, RegistrationPage::class.java)
        startActivity(registerIntent)
    }

}