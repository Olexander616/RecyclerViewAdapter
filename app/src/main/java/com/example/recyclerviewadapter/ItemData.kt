package com.example.recyclerviewadapter

data class ItemData(val type: ItemType, val avatarResId: Int? = null, val text: String)

enum class ItemType{ USER, GROUP }