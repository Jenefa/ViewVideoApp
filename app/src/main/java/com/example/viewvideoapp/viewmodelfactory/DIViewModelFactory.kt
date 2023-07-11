package com.example.viewvideoapp.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance
import org.kodein.type.erased

class DIViewModelFactory(private val di: DI) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        di.direct.instance<ViewModel>(erased(modelClass)) as T
}

