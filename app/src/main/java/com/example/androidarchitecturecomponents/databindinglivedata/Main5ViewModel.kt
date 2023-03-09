package com.example.androidarchitecturecomponents.databindinglivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Main5ViewModel : ViewModel() {

    private var count = 0
    private val stringMutableLiveData = MutableLiveData<String>("This is fact!")
    private val intMutableLiveData = MutableLiveData<Int>(0)
    val editStringMutableLiveData = MutableLiveData<String>("This is fact!")

    val stringLiveData: LiveData<String> get() = stringMutableLiveData
    val intLiveData: LiveData<Int> get() = intMutableLiveData

    fun updateStringLiveData() {
        stringMutableLiveData.value = "Another Fact!"
    }

    fun updateIntLiveData() {
        intMutableLiveData.value = ++count
    }
}