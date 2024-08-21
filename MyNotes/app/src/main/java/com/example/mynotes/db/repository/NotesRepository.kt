package com.example.mynotes.db.repository

import android.content.Context
import android.provider.ContactsContract.Intents.Insert
import com.example.mynotes.db.NotesDatabase
import com.example.mynotes.db.dao.NotesDao
import com.example.mynotes.db.entities.Notes

class NotesRepository(context: Context) {
    private val notesDao:NotesDao
    init {
        var db =NotesDatabase.getDatabase(context)
        notesDao = db.getNotesDao()
    }

     suspend fun insert(notes: Notes){
         notesDao.Insert(notes);
     }

    suspend fun update(notes: Notes){
        notesDao.update(notes)
    }

    suspend fun delete(notes: Notes){
        notesDao.delete(notes);
    }
    suspend fun getNotes():List<Notes>{
        return notesDao.getAllNotes()
    }

    suspend fun getNotesById(id: Int): Notes{
        return notesDao.getNoteById(id);
    }
}