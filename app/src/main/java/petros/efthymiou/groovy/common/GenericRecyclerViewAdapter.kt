package petros.efthymiou.groovy.common

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerViewAdapter(
private val viewHolderFactory: ViewHolderFactory
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<RecyclerViewAdapterCellController>() {
        override fun areItemsTheSame(
            oldItem: RecyclerViewAdapterCellController,
            newItem: RecyclerViewAdapterCellController
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RecyclerViewAdapterCellController,
            newItem: RecyclerViewAdapterCellController
        ): Boolean {
            return oldItem.hash == newItem.hash
        }
    })

    override fun getItemViewType(position: Int): Int {
        return differ.currentList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolderFactory.viewHolderFor(viewType, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        differ.currentList[position].adapter.onBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}