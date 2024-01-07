package com.example.versiculosapp.ui.adivinar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdivinarViewModel(private val opcion1: String,private val opcion2: String,private val opcion3: String,private val versiculo:String) : ViewModel()  {

    private val _versiculo = MutableLiveData<String>().apply {
        value = versiculo
    }

    val versiculoLive: LiveData<String> = _versiculo

    private val _opcion1 = MutableLiveData<String>().apply {
        value = opcion1
    }

    private val _opcion2 = MutableLiveData<String>().apply {
        value = opcion2
    }

    private val _opcion3 = MutableLiveData<String>().apply {
        value = opcion3
    }


}