package com.example.marvel.domain.model

data class Comics(
    val id: Int,
    val title: String,
    val imgUrl: String,
    val modified: String,
    val pageCount: Int,
    val description: String
)
