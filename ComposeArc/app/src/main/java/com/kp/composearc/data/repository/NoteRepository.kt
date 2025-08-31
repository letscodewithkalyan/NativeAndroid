package com.kp.composearc.data.repository

import com.kp.composearc.data.datasources.local.dao.NotesDao
import javax.inject.Inject


class NoteRepository @Inject constructor(val notesDao: NotesDao) {

}