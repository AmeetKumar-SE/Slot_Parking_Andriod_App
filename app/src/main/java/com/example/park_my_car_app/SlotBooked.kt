package com.example.park_my_car_app

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SlotBooked : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_booked)

        var emailTextLabel = findViewById<TextView>(R.id.emailConfirmationLabel)
        var  email = intent.getStringExtra("email").toString()
        emailTextLabel.text = "You confirmation slot parking email has been send to " + email;

        var listView = findViewById<ListView>(R.id.listBook)
        var itemAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getAllData())
        listView.adapter = itemAdapter

    }

    fun getAllData() : List<String>{
        var db = openOrCreateDatabase("ParkMyCar", MODE_PRIVATE, null)
        val query = "SELECT  * FROM slot"
        val cursor : Cursor = db.rawQuery(query,null)
        var data = ""
        if(cursor.count>0){
            cursor.moveToFirst()
            do{
                if(cursor.getString(6)==intent.getStringExtra("email").toString()){
                    data += "Vehicle No: "+cursor.getString(1).toString() + "Model Name: "+cursor.getString(2).toString() +
                            "Starting Date: "+cursor.getString(3).toString() + "Ending Date: "+cursor.getString(4).toString() + "Slot No: "+cursor.getString(5).toString() + "Email: "+cursor.getString(6).toString() + "Address: "+cursor.getString(7).toString() + "\n"
                }

            }while(cursor.moveToNext())
        }

        var stringArray = data.lines()

        return stringArray

    }

}