package com.example.androidarchitecturecomponents.listadapteranddiffutilItemcallback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturecomponents.R

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        val programmingListRecyclerView =
            findViewById<RecyclerView>(R.id.programmingListRecyclerView)
        val programmingAdapter = ProgrammingAdapter()

        programmingAdapter.submitList(
            listOf(
                ProgrammingItem(1, "J", "Java"),
                ProgrammingItem(2, "K", "Kotlin"),
                ProgrammingItem(3, "X", "XML"),
                ProgrammingItem(4, "F", "Flutter")
            )
        )

        programmingListRecyclerView.layoutManager = LinearLayoutManager(this)
        programmingListRecyclerView.setHasFixedSize(true)
        programmingListRecyclerView.adapter = programmingAdapter

        Handler(Looper.getMainLooper()).postDelayed({
            programmingAdapter.submitList(
                listOf(
                    ProgrammingItem(1, "J", "Java"),
                    ProgrammingItem(5, "N", "Node"),
                    ProgrammingItem(6, "G", "GoLang"),
                    ProgrammingItem(7, "R", "Rust"),
                    ProgrammingItem(8, "A", "Android")
                )
            )
        }, 5000)
    }
}