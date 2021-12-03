package com.example.marvel.data.remote.respons

import com.google.gson.annotations.SerializedName


data class StoriesDto(
    @SerializedName("characters")
    val characters: SubList? = null,
    @SerializedName("comics")
    val comics: SubList? = null,
    @SerializedName("creators")
    val creators: SubList? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("events")
    val events: SubList? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("originalIssue")
    val originalIssue: SubList? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: SubList? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null
)