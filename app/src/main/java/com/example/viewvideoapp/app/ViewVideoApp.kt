package com.example.viewvideoapp.app

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.viewvideoapp.ui.main.viewmodel.MainViewModelFactory
import com.example.viewvideoapp.ui.myslider.viewmodel.MySliderViewModelFactory
import com.example.viewvideoapp.ui.viewvideo.viewmodel.ViewVideoViewModelFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.android.x.androidXModule


class ViewVideoApp : Application(), DIAware {
    override val di: DI by DI.lazy {
        import(androidXModule(this@ViewVideoApp))

        // ViewModelFactory binding
        bind<MainViewModelFactory>() with factory { MainViewModelFactory() }
        bind<ViewVideoViewModelFactory>() with factory { ViewVideoViewModelFactory() }


        bind<ViewModelProvider.Factory>() with factory {
            MySliderViewModelFactory()
        }
    }

}