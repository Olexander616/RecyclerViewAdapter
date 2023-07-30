package com.example.recyclerviewadapter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : ItemAdapter
    private lateinit var itemList: List<ItemData>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    itemList = generateListOf100Elements()

    recyclerView = findViewById(R.id.my_recycleView)
    adapter = ItemAdapter(this,
        {position -> showTost(position) },
        {position ->
        deleteItem(position)
    })
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = adapter
        //adapter.updateList(itemList)
        adapter.submitList(itemList)
}
    private fun showTost(position: Int){
        Toast.makeText(this, "Clicked on image ${position}", Toast.LENGTH_SHORT).show()
    }
    private fun deleteItem(position: Int){
        val updateList = itemList.toMutableList()
        updateList.removeAt(position)
        this.itemList = updateList
        adapter.submitList(itemList)
    }
}

fun generateListOf100Elements(): List<ItemData> {
    val itemList = mutableListOf<ItemData>()
    var count = 0
    for (i in 1..10) {
        itemList.add(ItemData(ItemType.GROUP, text = "Group $i"))
        for (j in 1..10) {
            val avatarResID =
                if (count % 2 == 0) R.drawable.ic_android_black_24dp else R.drawable.baseline_aod_24
            val name = "Name$count"
            itemList.add(ItemData(ItemType.USER, avatarResID, name))
            count++
        }
    }
    return itemList
}