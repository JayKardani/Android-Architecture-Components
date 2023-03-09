package com.example.androidarchitecturecomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidarchitecturecomponents.databinding.MainActivity4
import com.example.androidarchitecturecomponents.databindingadapters.MainActivity6
import com.example.androidarchitecturecomponents.databindinglivedata.MainActivity5
import com.example.androidarchitecturecomponents.listadapteranddiffutilItemcallback.MainActivity9
import com.example.androidarchitecturecomponents.livedata.MainActivity3
import com.example.androidarchitecturecomponents.mvvm.MainActivity8
import com.example.androidarchitecturecomponents.mvvmcompleteexample.MainActivity11
import com.example.androidarchitecturecomponents.retrofit.MainActivity10
import com.example.androidarchitecturecomponents.roomdatabase.MainActivity7
import com.example.androidarchitecturecomponents.viewmodel.MainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainRoomDatabase.getDatabase(applicationContext)

        findViewById<Button>(R.id.viewModelButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity2::class.java))
        }

        findViewById<Button>(R.id.liveDataButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity3::class.java))
        }

        findViewById<Button>(R.id.dataBindingButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity4::class.java))
        }

        findViewById<Button>(R.id.dataBindingLiveDataButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity5::class.java))
        }

        findViewById<Button>(R.id.dataBindingAdaptersButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity6::class.java))
        }

        findViewById<Button>(R.id.rooDatabaseButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity7::class.java))
        }

        findViewById<Button>(R.id.mvvmArchitectureButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity8::class.java))
        }

        findViewById<Button>(R.id.listAdapterANDDiffUtilItemCallbackButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity9::class.java))
        }

        findViewById<Button>(R.id.retrofitButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity10::class.java))
        }

        findViewById<Button>(R.id.mvvmCompleteExampleButton).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity11::class.java))
        }
    }
}