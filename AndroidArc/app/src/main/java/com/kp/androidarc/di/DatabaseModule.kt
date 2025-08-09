package com.kp.androidarc.di

import android.content.Context
import androidx.annotation.UiContext
import androidx.room.Room
import com.kp.androidarc.data.datasources.local.AppDatabase
import com.kp.androidarc.data.datasources.local.dao.NotesDao
import com.kp.androidarc.data.datasources.local.dao.UserDao
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
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase{
       return Room.databaseBuilder(context, AppDatabase::class.java, "notes_db").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) : UserDao{
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideNotesDao(database: AppDatabase): NotesDao {
        return database.notesDao();
    }
}