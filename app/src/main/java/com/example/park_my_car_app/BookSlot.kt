package com.example.park_my_car_app

import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class BookSlot : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    var DBNAME = "ParkMyCar"
    lateinit var vehicleBookField : EditText
    lateinit var modelBookField : EditText
    lateinit var startinDateBookField : EditText
    lateinit var endingDateBookField : EditText
    lateinit var slotBookField : TextView
    var username = ""
    var email = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_slot)

        db = openOrCreateDatabase(DBNAME, MODE_PRIVATE, null)

        val tableQuery =
            "CREATE TABLE IF NOT EXISTS slot(id Integer PRIMARY KEY AUTOINCREMENT, vehicle_no TEXT, model_name TEXT, starting_date TEXT, " +
                    "ending_date TEXT, slot_no  TEXT,email TEXT, address TEXT)"

        db.execSQL(tableQuery)

        vehicleBookField = findViewById(R.id.vehicleBook)
        modelBookField = findViewById(R.id.modelBook)
        startinDateBookField = findViewById(R.id.startingDateField)
        endingDateBookField = findViewById(R.id.endingDateField)
        slotBookField = findViewById(R.id.slotNoField)
        slotBookField.text = intent.getStringExtra("slotno").toString()


    }

    fun onSlotBookClick(view: View){
        var cv = ContentValues()
        cv.put("vehicle_no",vehicleBookField.text.toString())
        cv.put("model_name",modelBookField.text.toString())
        cv.put("starting_date",startinDateBookField.text.toString())
        cv.put("ending_date",endingDateBookField.text.toString())
        cv.put("slot_no",slotBookField.text.toString())
        cv.put("address",intent.getStringExtra("address3"))

        username = intent.getStringExtra("username3").toString()
        email = getAllData()
        cv.put("email",email)
        db.insert("slot",null,cv)
        db.close()


      //  sendEmail()

        var Bookedintent = Intent(this, SlotBooked::class.java)
        Bookedintent.putExtra("email",email)
        startActivity(Bookedintent)

    }


//    fun sendEmail(){
//       var emailIntent = Intent(Intent.ACTION_SEND)
//        emailIntent.setData(Uri.parse("mailto:"))
//        emailIntent.setType("text/plain")
//        emailIntent.putExtra(Intent.EXTRA_EMAIL,email)
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Parking Slot Confirmation")
//        emailIntent.putExtra(Intent.EXTRA_TEXT, ("Username: " + username + "\nSlot NO" + slotBookField.text.toString() + "\nAddress" + intent.getStringExtra("address3") + "\nVehcile No "+ vehicleBookField.text.toString()))
//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
//            finish()
//        } catch (ex: ActivityNotFoundException) {
//            Toast.makeText(
//                this,
//                "There is no email client installed.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//    }

    fun getAllData() : String{
        val query = "SELECT  * FROM users"
        val cursor : Cursor = db.rawQuery(query,null)
        var data = ""
        if(cursor.count>0){
            cursor.moveToFirst()
            do{
                if(cursor.getString(2)==username){
                    data = cursor.getString(4).toString()
                }

            }while(cursor.moveToNext())
        }

        return data

    }
}