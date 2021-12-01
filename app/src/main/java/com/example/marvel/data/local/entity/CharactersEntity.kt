package com.example.marvel.data.local.entity

import androidx.room.*

@Entity
data class CharactersEntity(
    @PrimaryKey var id: Long,
    var name: String,
    var description: String,
    var modified: String,
    var imgUrl: String
)