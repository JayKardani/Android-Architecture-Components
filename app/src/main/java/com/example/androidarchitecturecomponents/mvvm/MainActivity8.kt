package com.example.androidarchitecturecomponents.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.MainRoomDatabase
import com.example.androidarchitecturecomponents.R
import com.example.androidarchitecturecomponents.databinding.ActivityMain8Binding

class MainActivity8 : AppCompatActivity() {

    lateinit var activityMain8Binding: ActivityMain8Binding
    lateinit var main8ViewModel: Main8ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain8Binding = DataBindingUtil.setContentView(this, R.layout.activity_main8)

        val quoteDAO = MainRoomDatabase.getDatabase(applicationContext).quoteDAO()
        val quoteRepository = QuoteRepository(quoteDAO)

        main8ViewModel = ViewModelProvider(
            this,
            Main8ViewModelFactory(quoteRepository)
        )[Main8ViewModel::class.java]

        main8ViewModel.getQuotes().observe(this) {
            activityMain8Binding.quotes = it.toString()
        }

        activityMain8Binding.btnAddQuote.setOnClickListener {
            main8ViewModel.insertQuotes(Quote(0,"This is testing","Testing"))
        }
    }
}