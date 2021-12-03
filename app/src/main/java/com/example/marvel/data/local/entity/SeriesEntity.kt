package com.example.marvel.data.local.entity

import androidx.room.*


@Entity(tableName = "Series_table")
data class SeriesEntity(
    @PrimaryKey val id: Long,
    val description: String,
    val endYear: Int,
    val modified: String,
    val rating: String,
    val startYear: Int,
    val title: String,
    val type: String,
    val imgUrl: String,
)
