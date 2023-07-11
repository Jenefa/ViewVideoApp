package com.example.viewvideoapp.ui.viewvideo.view

import VideoAdapter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewvideoapp.R
import com.example.viewvideoapp.app.ViewVideoApp
import com.example.viewvideoapp.databinding.ActivityMainBinding
import com.example.viewvideoapp.databinding.FragmentViewVideoBinding
import com.example.viewvideoapp.ui.base.view.BaseFragment
import com.example.viewvideoapp.ui.main.viewmodel.MainViewModelFactory
import com.example.viewvideoapp.ui.viewvideo.viewmodel.ViewVideoViewModel
import com.example.viewvideoapp.ui.viewvideo.viewmodel.ViewVideoViewModelFactory
import com.example.viewvideoapp.viewmodelfactory.DIViewModelFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.direct
import org.kodein.di.instance


class ViewVideoFragment : BaseFragment(), DIAware {
    private lateinit var binding: FragmentViewVideoBinding

    override val di: DI by closestDI()

    private lateinit var viewVideoViewModel: ViewVideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_video, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewVideoViewModelFactory: ViewVideoViewModelFactory by instance()
        viewVideoViewModel = ViewModelProvider(this, viewVideoViewModelFactory)[ViewVideoViewModel::class.java]
        binding.lifecycleOwner = viewLifecycleOwner

        val layoutManger = LinearLayoutManager(requireActivity())
        binding.rvVideo.layoutManager = layoutManger
        binding.rvVideo.adapter = VideoAdapter(viewVideoViewModel.getVideoList())


    }

}