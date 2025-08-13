package com.kp.composearc.di

import android.content.Context
import androidx.room.Room
import com.kp.composearc.data.datasources.local.NotesDatabase
import com.kp.composearc.data.datasources.local.dao.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NotesDatabase{
        return Room.databaseBuilder(context, NotesDatabase::class.java, "notes_db").build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(database: NotesDatabase) : NotesDao{
        return database.notesDao()
    }
}