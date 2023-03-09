package com.example.androidarchitecturecomponents.mvvmcompleteexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidarchitecturecomponents.mvvmcompleteexample.models.Result

@Dao
interface QuoteListDAO {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM QuoteList")
    fun getQuotes(): List<Result>
}