package com.kp.androidarc.data.datasources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kp.androidarc.data.datasources.local.dao.NotesDao
import com.kp.androidarc.data.datasources.local.dao.UserDao
import com.kp.androidarc.data.datasources.local.entities.Note
import com.kp.androidarc.data.datasources.local.entities.User

@Database(entities = [User::class, Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun notesDao() : NotesDao
}