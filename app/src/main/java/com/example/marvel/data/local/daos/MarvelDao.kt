package com.example.marvel.data.local.daos

import androidx.room.*
import com.example.marvel.data.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(item: List<CharactersEntity>)

    @Query("Select * From characters_table")
    fun getCharacters(): Flow<List<CharactersEntity>>


    @Insert
    suspend fun insertSearchCharacterResult(item: List<SearchCharacterResultEntity>)

    @Query("Select * From searchCharacterResult_table")
    fun getSearchCharacterResult(): Flow<List<SearchCharacterResultEntity>>

    @Query("Select * From searchCharacterResult_table ORDER BY id DESC LIMIT 1")
    fun getLastSearchCharacterResult(): Flow<List<SearchCharacterResultEntity>>

    @Query("Select * From searchCharacterResult_table Where name = :name")
    fun getSearchCharacterResultByName(name: String): Flow<List<SearchCharacterResultEntity>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(item: List<ComicsEntity>)

    @Query("Select * From Comics_table")
    fun getComics(): Flow<List<ComicsEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(item: List<SeriesEntity>)

    @Query("Select * From Series_table")
    fun getSeries(): Flow<List<SeriesEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(item: List<StoriesEntity>)

    @Query("Select * From Stories_table")
    fun getStories(): Flow<List<StoriesEntity>>


}