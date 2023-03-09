package com.example.androidarchitecturecomponents.mvvmcompleteexample.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitecturecomponents.MainRoomDatabase
import com.example.androidarchitecturecomponents.mvvmcompleteexample.api.QuoteService
import com.example.androidarchitecturecomponents.mvvmcompleteexample.models.QuoteList
import com.example.androidarchitecturecomponents.mvvmcompleteexample.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val mainRoomDatabase: MainRoomDatabase,
    private val applicationContext: Context
) {

    private val quoteListLiveData = MutableLiveData<Response<QuoteList>>()

    val quote: LiveData<Response<QuoteList>>
        get() = quoteListLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            try {
                val result = quoteService.getQuotes(page)
                if (result?.body() != null) {
                    mainRoomDatabase.quoteListDAO().addQuotes(result.body()!!.results)
                    quoteListLiveData.postValue(Response.Success(result.body()))
                } else {
                    quoteListLiveData.postValue(Response.Error("API Error"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                quoteListLiveData.postValue(Response.Error(e.message.toString()))
            }
        } else {
            try {
                val quotes = mainRoomDatabase.quoteListDAO().getQuotes()
                val quoteList = QuoteList(1, 1, 1, quotes, 1, 1)
                quoteListLiveData.postValue(Response.Success(quoteList))
            } catch (e: Exception) {
                e.printStackTrace()
                quoteListLiveData.postValue(Response.Error(e.message.toString()))
            }
        }
    }

    // TODO Use by WorkManager
    suspend fun getQuotesBackground() {
        val randomNumber = (Math.random() * 10).toInt()
        val result = quoteService.getQuotes(randomNumber)
        if (result?.body() != null) {
            mainRoomDatabase.quoteListDAO().addQuotes(result.body()!!.results)
        }
    }
}