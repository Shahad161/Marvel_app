package com.example.marvel.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel.data.local.daos.MarvelDao
import com.example.marvel.data.local.entity.CharactersEntity


@Database(entities = [CharactersEntity::class], version = 1)
abstract class MarvelDataBase: RoomDatabase() {

    abstract fun MarvelDao(): MarvelDao

    companion object{

        private const val DATABASE_NAME = "MarvelDataBase"
        private var instance: MarvelDataBase? = null

        fun init(context: Context): MarvelDataBase{
            return instance ?: synchronized(this){ buildDatabase(context)
                .also{ dataBase -> instance = dataBase }
            }
        }

        fun getInstance() = instance!!

        private fun buildDatabase(context: Context): MarvelDataBase{
            return Room.databaseBuilder(context, MarvelDataBase::class.java, DATABASE_NAME)
                .build()
        }

    }
}