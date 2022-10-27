package petros.efthymiou.groovy.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import petros.efthymiou.groovy.R
import petros.efthymiou.groovy.common.ViewHolder
import petros.efthymiou.groovy.common.ViewHolderFactory

class PlaylistViewHolderFactory(
    private val inflater: LayoutInflater
): ViewHolderFactory {

    override fun viewHolderFor(type: Int, parent: ViewGroup) : RecyclerView.ViewHolder {
        return when (PlaylistViewHolderType.typeFor(type)) {
            PlaylistViewHolderType.PLAYLIST -> {
                val view = inflater.inflate(R.layout.playlist_item, parent, false)
                ViewHolder(view)
            }
            PlaylistViewHolderType.ALBUM -> {
                val view = inflater.inflate(R.layout.playlist_item, parent, false)
                ViewHolder(view)
            }
        }
    }
}