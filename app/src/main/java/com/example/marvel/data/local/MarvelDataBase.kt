package com.example.marvel.data.local

import android.content.Context
import androidx.room.*
import com.example.marvel.data.local.daos.MarvelDao
import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.local.entity.ComicsEntity


@Database(entities = [CharactersEntity::class, ComicsEntity::class], version = 1)
abstract class MarvelDataBase: RoomDatabase() {

    abstract fun MarvelDao(): MarvelDao

}