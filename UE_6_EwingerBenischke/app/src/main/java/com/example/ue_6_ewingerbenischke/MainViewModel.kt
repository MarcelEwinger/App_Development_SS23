package com.example.ue_6_ewingerbenischke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //_userNumber die mit dem Initialwert "0.0" initialisiert wird.
    // Sie wird als lazy-Eigenschaft deklariert, was bedeutet, dass sie erst initialisiert wird, wenn sie zum ersten Mal verwendet wird.
    private val _userNumber by lazy { MutableLiveData("0.0") }
    val userNumber: MutableLiveData<String> by lazy { _userNumber }
}