package com.kp.composearc.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kp.composearc.data.datasources.local.dao.NotesDao
import com.kp.composearc.data.datasources.local.entities.NoteEntity

@Database(entities = [NoteEntity::class] , version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao() : NotesDao
}