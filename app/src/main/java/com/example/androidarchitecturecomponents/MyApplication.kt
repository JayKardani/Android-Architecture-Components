package com.example.androidarchitecturecomponents

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.androidarchitecturecomponents.mvvmcompleteexample.api.QuoteService
import com.example.androidarchitecturecomponents.mvvmcompleteexample.api.RetrofitHelper
import com.example.androidarchitecturecomponents.mvvmcompleteexample.repository.QuoteRepository
import com.example.androidarchitecturecomponents.mvvmcompleteexample.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class MyApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest =
            PeriodicWorkRequest
                .Builder(QuoteWorker::class.java, 1, TimeUnit.HOURS)
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val mainRoomDatabase = MainRoomDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, mainRoomDatabase, applicationContext)
    }
}