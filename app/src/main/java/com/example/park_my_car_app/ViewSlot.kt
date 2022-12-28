package com.example.park_my_car_app

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class ViewSlot : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_slot)
    }

    fun onSlotIdClicked(view: View){
        var bookSlotIntent = Intent(this,BookSlot::class.java)
        bookSlotIntent.putExtra("slotno",findViewById<Button>(view.id).text)
        bookSlotIntent.putExtra("username3",intent.getStringExtra("username2"))
        bookSlotIntent.putExtra("address3",intent.getStringExtra("address"))
        startActivity(bookSlotIntent)
    }

}