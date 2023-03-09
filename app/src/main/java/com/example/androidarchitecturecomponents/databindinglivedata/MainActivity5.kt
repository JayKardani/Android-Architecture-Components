package com.example.androidarchitecturecomponents.databindinglivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.R
import com.example.androidarchitecturecomponents.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {

    lateinit var activityMain5Binding: ActivityMain5Binding
    lateinit var main5ViewModel: Main5ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain5Binding = DataBindingUtil.setContentView(this, R.layout.activity_main5)
        main5ViewModel = ViewModelProvider(this)[Main5ViewModel::class.java]

        activityMain5Binding.main5ViewModel = main5ViewModel
        activityMain5Binding.lifecycleOwner = this

        main5ViewModel.stringLiveData.observe(this) {
            activityMain5Binding.textView1.text = it
        }

        activityMain5Binding.buttonUpdate1.setOnClickListener { main5ViewModel.updateStringLiveData() }
    }
}