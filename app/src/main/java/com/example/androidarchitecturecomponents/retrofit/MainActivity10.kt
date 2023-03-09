package com.example.androidarchitecturecomponents.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import com.example.androidarchitecturecomponents.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity10 : AppCompatActivity() {

    private val textView: TextView
        get() = findViewById(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val quoteAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)
        GlobalScope.launch {
            val result = quoteAPI.getQuotes(1)
            val quoteList = result.body()
            quoteList?.results?.forEach {
                Log.e("Check", it.content);
            }
            MainScope().launch {
                textView.text = quoteList.toString()
            }
        }
    }
}