import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import com.example.viewvideoapp.databinding.ItemVideoViewBinding
import com.example.viewvideoapp.ui.viewvideo.model.Video


class VideoAdapter(private val videos: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemVideoViewBinding = ItemVideoViewBinding.inflate(layoutInflater, parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videoUrl = videos[position].videoUrl
        holder.bind(videoUrl)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    inner class VideoViewHolder(private val binding: ItemVideoViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(videoUrl: String) {
            // Set media controller for play, pause, etc. options
            val mediaController = MediaController(binding.root.context)
            mediaController.setAnchorView(binding.videoView)
            binding.videoView.setMediaController(mediaController)

            with(binding) {
                videoView.setVideoURI(Uri.parse(videoUrl))
            }
        }
    }
}