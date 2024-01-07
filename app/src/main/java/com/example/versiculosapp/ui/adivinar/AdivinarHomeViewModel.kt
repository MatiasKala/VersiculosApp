package com.example.versiculosapp.ui.adivinar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdivinarHomeViewModel : ViewModel() {

   private val _text = MutableLiveData<String>().apply {
        value = "Bienvenido a Versículos App"
    }
    val text: LiveData<String> = _text

}