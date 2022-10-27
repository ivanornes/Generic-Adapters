package petros.efthymiou.groovy.playlist

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import petros.efthymiou.groovy.R

data class PlaylistCellViewModel(
    val name: String,
    val category: String,
    val image: Int
)

class PlaylistCellController(
    val viewModel: PlaylistCellViewModel,
    val onClick: (()->Unit)? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        throw Exception("Not needed")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val playlistName: TextView = holder.itemView.findViewById(R.id.playlist_name)
        val playlistCategory: TextView = holder.itemView.findViewById(R.id.playlist_category)
        val playlistImage: ImageView = holder.itemView.findViewById(R.id.playlist_image)
        val root: View = holder.itemView.findViewById(R.id.playlist_item_root)

        playlistName.text = viewModel.name
        playlistCategory.text = viewModel.category
        playlistImage.setImageResource(viewModel.image)
        root.setOnClickListener { onClick?.invoke() }
    }

    override fun getItemCount(): Int { return 1 }
}