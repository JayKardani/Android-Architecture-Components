package com.example.androidarchitecturecomponents.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Main8ViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Main8ViewModel(quoteRepository) as T
    }
}