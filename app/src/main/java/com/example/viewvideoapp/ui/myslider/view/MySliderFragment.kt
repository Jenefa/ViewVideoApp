package com.example.viewvideoapp.ui.myslider.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewvideoapp.R
import com.example.viewvideoapp.ui.myslider.viewmodel.MySliderViewModel

class MySliderFragment : Fragment() {

    companion object {
        fun newInstance() = MySliderFragment()
    }

    private lateinit var viewModel: MySliderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_slider, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MySliderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}