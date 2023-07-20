package com.example.recyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val itemList = listOf(
        ItemData(R.drawable.ic_android_black_24dp, "Ann 1"),
        ItemData(R.drawable.baseline_aod_24, "Igor 2"),
        ItemData(R.drawable.baseline_aod_24, "Kate 3")
        // Add more items as needed
    )

    //val itemList = generateListOf100Elements()

    recyclerView = findViewById(R.id.my_recycleView)
    val adapter = ItemAdapter(this, itemList)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = adapter
}
}

//fun generateListOf100Elements(): List<ItemData> {
//    val itemList = mutableListOf<Int>()
//    for (i in 1..100)
//        itemList.add(i)
//    }
//    return itemList
//}