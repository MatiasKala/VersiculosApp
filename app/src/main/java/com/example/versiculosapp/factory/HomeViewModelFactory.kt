package com.example.versiculosapp.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.versiculosapp.ui.home.HomeViewModel;

public class HomeViewModelFactory(private val versiculoDestacado: String,private val versiculoDestacadoCita: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(versiculoDestacado,versiculoDestacadoCita) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
