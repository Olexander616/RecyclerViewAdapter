package com.example.recyclerviewadapter

sealed class ItemData{
    data class UserType(val text: String, val avatarResId: Int): ItemData()
    data class GroupType(val groupName: String): ItemData()
}
//data class ItemData(val type: ItemType, val avatarResId: Int? = null, val text: String)
//
//enum class ItemType{ USER, GROUP }