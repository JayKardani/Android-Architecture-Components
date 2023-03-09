package com.example.androidarchitecturecomponents.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.R

class MainActivity3 : AppCompatActivity() {

    lateinit var main3ViewModel: Main3ViewModel

    private val textView1: TextView
        get() = findViewById(R.id.textView1)

    private val buttonUpdate1: Button
        get() = findViewById(R.id.buttonUpdate1)

    private val textView2: TextView
        get() = findViewById(R.id.textView2)

    private val buttonUpdate2: Button
        get() = findViewById(R.id.buttonUpdate2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        main3ViewModel = ViewModelProvider(this)[Main3ViewModel::class.java]

        main3ViewModel.stringLiveData.observe(this) {
            textView1.text = it
        }

        buttonUpdate1.setOnClickListener {
            main3ViewModel.updateStringLiveData()
        }

        main3ViewModel.intLiveData.observe(this) {
            textView2.text = it.toString()
        }

        buttonUpdate2.setOnClickListener {
            main3ViewModel.updateIntLiveData()
        }
    }
}