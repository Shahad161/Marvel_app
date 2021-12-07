package com.example.marvel.domain.model


data class Series(
    val id: Int,
    val endYear: Int,
    val rating: String,
    val startYear: Int,
    val name: String,
    val type: String,
    val imgUrl: String,
)
