package com.example.marvel.data.local.daos

import androidx.room.*
import com.example.marvel.data.local.entity.CharactersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(item: List<CharactersEntity>)

    @Query("Select * From CharactersEntity")
    fun getCharacters(): Flow<List<CharactersEntity>>

}