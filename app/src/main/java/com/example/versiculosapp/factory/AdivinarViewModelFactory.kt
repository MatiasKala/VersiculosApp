package com.example.versiculosapp.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.versiculosapp.ui.adivinar.AdivinarViewModel

public class AdivinarViewModelFactory (private val opcion1: String,private val opcion2: String,private val opcion3: String,private val versiculo:String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdivinarViewModel::class.java)) {
            return AdivinarViewModel(opcion1,opcion2,opcion3,versiculo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}