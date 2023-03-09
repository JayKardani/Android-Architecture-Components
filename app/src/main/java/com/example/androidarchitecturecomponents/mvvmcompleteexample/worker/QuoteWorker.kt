package com.example.androidarchitecturecomponents.mvvmcompleteexample.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.androidarchitecturecomponents.MyApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private val context: Context, params: WorkerParameters) : Worker(context, params){
    override fun doWork(): Result {
        val quoteRepository = (context as MyApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch {
            quoteRepository.getQuotesBackground()
        }
        return Result.success()
    }
}