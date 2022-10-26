package petros.efthymiou.groovy.common

import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapterCellController(
    val id: String,
    val hash: String,
    val type: Int,
    val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
)