package com.example.ue_6_ewingerbenischke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _userNumber by lazy { MutableLiveData("0.0") }
    val userNumber: MutableLiveData<String> by lazy { _userNumber }
}