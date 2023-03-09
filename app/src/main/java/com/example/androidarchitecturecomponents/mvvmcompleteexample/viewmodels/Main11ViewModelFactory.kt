package com.example.androidarchitecturecomponents.mvvmcompleteexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturecomponents.mvvmcompleteexample.repository.QuoteRepository

class Main11ViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Main11ViewModel(quoteRepository) as T
    }
}