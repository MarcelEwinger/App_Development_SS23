package com.example.ue_6_ewingerbenischke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _userEmailLD by lazy { MutableLiveData("test@gmail.com") }
    val userEmailLD: MutableLiveData<String> by lazy { _userEmailLD }
}