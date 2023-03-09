package com.example.androidarchitecturecomponents.mvvmcompleteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.MyApplication
import com.example.androidarchitecturecomponents.R
import com.example.androidarchitecturecomponents.mvvmcompleteexample.repository.Response
import com.example.androidarchitecturecomponents.mvvmcompleteexample.viewmodels.Main11ViewModel
import com.example.androidarchitecturecomponents.mvvmcompleteexample.viewmodels.Main11ViewModelFactory

class MainActivity11 : AppCompatActivity() {

    lateinit var main11ViewModel: Main11ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        val quoteRepository = (application as MyApplication).quoteRepository

        main11ViewModel = ViewModelProvider(
            this,
            Main11ViewModelFactory(quoteRepository)
        )[Main11ViewModel::class.java]

        main11ViewModel.quotes.observe(this) {
            when (it) {
                is Response.Loading -> {}
                is Response.Success -> {
                    it.data?.let { it1 ->
                        Toast.makeText(
                            this@MainActivity11,
                            it1.results.size.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this@MainActivity11, "Some Error Occurs", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}