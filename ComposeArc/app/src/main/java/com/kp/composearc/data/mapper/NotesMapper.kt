package com.kp.composearc.data.mapper

import com.kp.composearc.data.datasources.local.entities.NoteEntity
import com.kp.composearc.data.model.NoteModel

fun NoteEntity.toModel(): NoteModel {
    return NoteModel(
        id = id ?: 0,
        title = title,
        description = description
    )
}