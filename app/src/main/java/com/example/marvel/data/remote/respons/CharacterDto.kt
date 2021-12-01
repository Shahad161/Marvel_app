package com.example.marvel.data.remote.respons


import android.media.metrics.Event
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("comics")
    val subList: SubList? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("events")
    val events: SubList? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: SubList? = null,
    @SerializedName("stories")
    val stories: SubList? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)