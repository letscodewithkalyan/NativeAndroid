package com.kp.androidarc.data.models

import android.os.Parcelable
import com.kp.androidarc.data.datasources.local.entities.Note
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(val id: Int, val title: String, val description: String) : Parcelable

fun Note.toModel(): NoteModel {
    return NoteModel(
        id = id ?: 0,
        title = title,
        description = description
    )
}