package com.example.androidarchitecturecomponents.databindingadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturecomponents.R
import com.example.androidarchitecturecomponents.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {

    lateinit var activityMain6Binding: ActivityMain6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain6Binding = DataBindingUtil.setContentView(this, R.layout.activity_main6)

        activityMain6Binding.post = Post(
            "Android Architecture Components and Jetpack",
            "Cheezy Code",
            "https://yt3.googleusercontent.com/ytc/AL5GRJW0GOC6R9gVDSzaIuxp2EZTQ0OFzLWCxJmTDnCM=s176-c-k-c0x00ffffff-no-rj"
        )
    }
}