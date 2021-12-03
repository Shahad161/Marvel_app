package com.example.marvel.data.local.daos

import androidx.room.*
import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.local.entity.SeriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(item: List<CharactersEntity>)

    @Query("Select * From characters_table")
    fun getCharacters(): Flow<List<CharactersEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(item: List<ComicsEntity>)

    @Query("Select * From Comics_table")
    fun getComics(): Flow<List<ComicsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(item: List<SeriesEntity>)

    @Query("Select * From Series_table")
    fun getSeries(): Flow<List<SeriesEntity>>

}