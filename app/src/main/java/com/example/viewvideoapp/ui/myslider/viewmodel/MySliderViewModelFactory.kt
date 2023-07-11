package com.example.viewvideoapp.ui.myslider.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MySliderViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MySliderViewModel::class.java)) {
            return MySliderViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}