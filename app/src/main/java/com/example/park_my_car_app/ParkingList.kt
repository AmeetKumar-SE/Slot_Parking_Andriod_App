package com.example.park_my_car_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ParkingList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking_list)
    }

    fun onClickIbaPark(view: View){
        var viewSlot = Intent(this, ViewSlot::class.java)
        viewSlot.putExtra("address","Sukkur IBA")
        viewSlot.putExtra("username2",intent.getStringExtra("username"))
        startActivity(viewSlot)
    }

    fun onClickGhantaGharPark(view: View){
        var viewSlot = Intent(this, ViewSlot::class.java)
        viewSlot.putExtra("address","Ghanta Ghar")
        viewSlot.putExtra("username2",intent.getStringExtra("username"))
        startActivity(viewSlot)

    }
}