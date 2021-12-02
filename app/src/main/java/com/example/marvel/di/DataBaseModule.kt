package com.example.marvel.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.marvel.data.local.MarvelDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {


    @Singleton
    @Provides
    fun provideMarvelDataBase(@ApplicationContext context: Context): MarvelDataBase {
        return Room.databaseBuilder(context, MarvelDataBase::class.java, "MarvelDataBase").build()
    }


    @Singleton
    @Provides
    fun provideDao(dataBase: MarvelDataBase) = dataBase.MarvelDao()

}