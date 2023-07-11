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

    inner class VideoViewHolder(binding: ItemVideoViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val binding: ItemVideoViewBinding
        private val mediaController: MediaController


        init {
            this.binding = binding
            mediaController = MediaController(this.binding.root.context)

        }

        fun bind(videoUrl: String) {
            with(binding) {
                videoView.setVideoURI(Uri.parse(videoUrl))
                mediaController.setAnchorView(videoView)
                videoView.setMediaController(mediaController)
            }
        }
    }
}