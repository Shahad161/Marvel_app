package com.example.marvel.data.local

import androidx.room.*
import com.example.marvel.data.local.daos.MarvelDao
import com.example.marvel.data.local.entity.*


@Database(entities = [
    CharactersEntity::class,
    ComicsEntity::class,
    SeriesEntity::class
                     ], version = 1)

abstract class MarvelDataBase: RoomDatabase() {

    abstract fun MarvelDao(): MarvelDao

}