package com.example.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Stories_table")
data class StoriesEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val modified: String,
    val imgUrl: String,
    val type: String,
    val description: String
    )
