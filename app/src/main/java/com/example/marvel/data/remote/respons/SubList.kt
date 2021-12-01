package com.example.marvel.data.remote.respons


import com.example.marvel.data.remote.response1.ItemX
import com.google.gson.annotations.SerializedName

data class SubList(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<Item>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)