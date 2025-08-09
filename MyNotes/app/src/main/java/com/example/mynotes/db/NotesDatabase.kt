package com.example.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.db.dao.NotesDao
import com.example.mynotes.db.entities.Notes

@Database(entities = arrayOf(Notes::class), version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun getNotesDao() : NotesDao

    companion object{
        @Volatile
        private var INSTANCE: NotesDatabase ? = null
        fun getDatabase(context: Context) : NotesDatabase{
            return  INSTANCE ?: synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "Test"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}