package petros.efthymiou.groovy.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import petros.efthymiou.groovy.R

class PlaylistViewHolderFactory(
    private val inflater: LayoutInflater
): ViewHolderFactory {
    enum class ViewHolderType {
        PLAYLIST, ALBUM;

        companion object {
            fun typeFor(value: Int) : ViewHolderType {
                return when (value) {
                    0 -> PLAYLIST
                    1 -> ALBUM
                    else -> { throw Exception("Unknown type") }
                }
            }
        }

        fun viewHolderType() : Int {
            return when (this) {
                PLAYLIST -> 0
                ALBUM -> 1
            }
        }
    }

    override fun viewHolderFor(type: Int, parent: ViewGroup) : RecyclerView.ViewHolder {
        return when (ViewHolderType.typeFor(type)) {
            ViewHolderType.PLAYLIST -> {
                val view = inflater.inflate(R.layout.playlist_item, parent, false)
                ViewHolder(view)
            }
            ViewHolderType.ALBUM -> {
                val view = inflater.inflate(R.layout.playlist_item, parent, false)
                ViewHolder(view)
            }
        }
    }
}