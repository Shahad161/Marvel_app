package com.example.marvel.data.remote.respons


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
)