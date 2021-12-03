package com.example.marvel.domain.model

data class Comics(
    val id: Int,
    val name: String,
    val imgUrl: String,
    val pageCount: Int,
    val description: String
)
