package com.example.viewvideoapp.ui.viewvideo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viewvideoapp.ui.viewvideo.model.Video

class ViewVideoViewModel : ViewModel() {

    private val videos = listOf(
        Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        Video("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//        Video("https://www.youtube.com/watch?v=2ejs-uxSbAk"),
//        Video("https://www.youtube.com/watch?v=DZGHPGvMp60")om/watch?v=2ejs-uxSbAk"),
//        Video("https://www.youtube.com/watch?v=DZGHPGvMp60")
    )

    fun getVideoList() : List<Video> {
        return videos
    }

}