package com.example.androidarchitecturecomponents.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var main2ViewModel: Main2ViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        main2ViewModel =
            ViewModelProvider(
                this,
                Main2ViewModelFactory(applicationContext)
            )[Main2ViewModel::class.java]
    }

    fun setQuote(quote:Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        setQuote(main2ViewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(main2ViewModel.nextQuote())
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, main2ViewModel.getQuote().text)
        startActivity(intent)
    }
}