package com.example.recyclerviewadapter

// ItemAdapter.kt
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context: Context,
                  //private val itemList: List<ItemData>,
                  private val onImageClick: (position: Int)->Unit,
                    private val onItemClicked: (position: Int) -> Unit ):
    //RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    androidx.recyclerview.widget.ListAdapter<ItemData, ItemAdapter.ItemViewHolder>(MyItemDiffCallback()){
    //private var itemList: List<ItemData> = listOf()
//    fun updateList(items: List<ItemData>){
//        this.itemList = items
//        notifyDataSetChanged()
//    }
//
//    fun updateListWithRemovePosition(items: List<ItemData>, position: Int){
//        this.itemList = itemList
//        notifyItemRemoved(position)
//        notifyItemRangeChanged(position,itemCount)
//    }
    class MyItemDiffCallback : DiffUtil.ItemCallback<ItemData>() {
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //val currentItem = itemList[position]
        val currentItem = getItem(position)
        holder.avatarImageView.setImageResource(currentItem.avatarResId)
        holder.textTextView.text = currentItem.text

        holder.avatarImageView.setOnClickListener{
            //onImageClick.invoke(position)
            onImageClick.invoke(holder.adapterPosition)
            //Toast.makeText(holder.itemView.context, "Cleked on image ${currentItem.text}", Toast.LENGTH_SHORT).show()
        }

        holder.textTextView.setOnClickListener{
           // removeItem(position)
            onItemClicked.invoke(holder.adapterPosition)
        }
    }

//    private fun removeItem(position: Int){
//        (itemList as MutableList<ItemData>).removeAt(position)
//        //notifyItemRemoved(position)
//        notifyDataSetChanged()
//    }

//    override fun getItemCount(): Int {
//        return itemList.size
//    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageViewer)
        val textTextView: TextView = itemView.findViewById(R.id.textView)
    }
}


