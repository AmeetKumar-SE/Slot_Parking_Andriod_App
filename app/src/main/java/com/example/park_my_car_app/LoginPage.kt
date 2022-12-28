package com.example.park_my_car_app

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginPage : AppCompatActivity() {
    lateinit var userName: EditText;
    lateinit var password : EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        userName = findViewById(R.id.vehicleBook)
        password = findViewById(R.id.slotBook)
    }

    fun onLogin(view: View){
        var dataList = getAllData().lines()
        var arrData : List<String>
        var count = 0
        var found = false
        for (i in dataList){
            arrData = i.split(",")
            for(j in arrData){
                if(j==userName.text.toString()){
                    count = count  + 1
                }else if(count == 1 && j==password.text.toString()){
                    count = count + 1
                }else{
                    count = 0
                }

                if(count==2){
                    found = true
                    break;
                }
            }

            if(found){
                break;
            }

        }

        if(found){
            var parkingListIntent = Intent(this,ParkingList::class.java)
            parkingListIntent.putExtra("username",userName.text.toString())
            startActivity(parkingListIntent)
        }

    }

        fun getAllData(): String{
        var db2 = openOrCreateDatabase("ParkMyCar", MODE_PRIVATE, null)
        val query = "SELECT * FROM " + "users"
        val cursor : Cursor = db2.rawQuery(query,null)
        var data = ""
        if(cursor.count>0){
            cursor.moveToFirst()
            do{
                data += cursor.getString(2) + ","+ cursor.getString(5)+"\n"
            }while(cursor.moveToNext())
        }

        return data

    }

}