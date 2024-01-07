package com.example.versiculosapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(private val versiculoDestacado: String,private val versiculoDestacadoCita:String) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bienvenido a Versículos App"
    }

    val text: LiveData<String> = _text

    private val _versiculoDestado = MutableLiveData<String>().apply {
        value = versiculoDestacado
    }

    private val _versiculoDestadoCita = MutableLiveData<String>().apply {
        value = versiculoDestacadoCita
    }
}