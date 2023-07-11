package com.example.viewvideoapp.ui.viewvideo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewVideoViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewVideoViewModel::class.java)) {
            return ViewVideoViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

