package com.example.recyclerviewadapter

// ItemAdapter.kt
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
//import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(private val context: Context,
                  //private val itemList: List<ItemData>,
                  private val onImageClick: (position: Int)->Unit,
                    private val onItemClicked: (position: Int) -> Unit ):
  ListAdapter<ItemData, RecyclerView.ViewHolder>(MyItemDiffCallback()){
    class MyItemDiffCallback : DiffUtil.ItemCallback<ItemData>() {
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem == newItem
        }
    }
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageViewer)
        val textTextView: TextView = itemView.findViewById(R.id.textView)
    }
    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTextView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun getItemViewType(position: Int): Int {
//        return  when(getItem(position).type){
//            ItemType.USER -> R.layout.list_item
//            ItemType.GROUP -> R.layout.group_item
        return  when(getItem(position)){
            is ItemData.UserType -> R.layout.list_item
            is ItemData.GroupType -> R.layout.group_item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==R.layout.list_item){
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }else{
            GroupViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        when(currentItem){
            is ItemData.UserType -> {
                holder as ItemViewHolder
                holder.avatarImageView.setImageResource(currentItem.avatarResId)
                holder.textTextView.text = currentItem.text
                holder.avatarImageView.setOnClickListener{
                    onImageClick.invoke(holder.adapterPosition)
                }
                holder.textTextView.setOnClickListener{
                    onItemClicked.invoke(holder.adapterPosition)
                }
            }
            is ItemData.GroupType ->{
                holder as GroupViewHolder
                holder.textTextView.text = currentItem.groupName
            }
        }
    }
}


