package com.example.androidarchitecturecomponents.mvvmcompleteexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecturecomponents.mvvmcompleteexample.models.QuoteList
import com.example.androidarchitecturecomponents.mvvmcompleteexample.repository.QuoteRepository
import com.example.androidarchitecturecomponents.mvvmcompleteexample.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Main11ViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes(1)
        }
    }

    val quotes : LiveData<Response<QuoteList>>
    get() = quoteRepository.quote
}