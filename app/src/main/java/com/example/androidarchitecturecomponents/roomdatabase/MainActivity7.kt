package com.example.androidarchitecturecomponents.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.androidarchitecturecomponents.MainRoomDatabase
import com.example.androidarchitecturecomponents.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity7 : AppCompatActivity() {

    lateinit var mainRoomDatabase: MainRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        mainRoomDatabase = MainRoomDatabase.getDatabase(applicationContext)

        GlobalScope.launch {
            mainRoomDatabase.contactDAO().insertContact(Contact(0, "Jay", "11111", Date(), 1))
        }
    }

    fun getContact(view: View) {
        mainRoomDatabase.contactDAO().getContact().observe(this) {
            Log.e("RoomDatabase", it.toString())
        }
    }
}