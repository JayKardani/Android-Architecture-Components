package com.example.androidarchitecturecomponents.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturecomponents.R
import com.example.androidarchitecturecomponents.viewmodel.Quote

class MainActivity4 : AppCompatActivity() {

    lateinit var activityMain4Binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain4Binding = DataBindingUtil.setContentView(this, R.layout.activity_main4)

        activityMain4Binding.quoteTextTextView1.text =
            "Bad times have a scientific value. These are occasions a good learner would not miss."
        activityMain4Binding.quoteAuthorTextView1.text = "Ralph Emerson"

        activityMain4Binding.quote =
            Quote("Gratitude is riches. Complaint is poverty.", "Doris Day")
    }
}