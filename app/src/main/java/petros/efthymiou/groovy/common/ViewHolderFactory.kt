package petros.efthymiou.groovy.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ViewHolderFactory {
    fun viewHolderFor(type: Int, parent: ViewGroup) : RecyclerView.ViewHolder
}