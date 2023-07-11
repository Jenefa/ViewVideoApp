package com.example.viewvideoapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewvideoapp.R
import com.example.viewvideoapp.databinding.ActivityMainBinding
import com.example.viewvideoapp.ui.main.viewmodel.MainViewModel
import com.example.viewvideoapp.ui.main.viewmodel.MainViewModelFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {
    private lateinit var binding: ActivityMainBinding

    override val di: DI by closestDI()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Access the ViewModel instance
        val mainViewModelFactory: MainViewModelFactory by instance()
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
    }
}