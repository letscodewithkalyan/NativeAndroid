package com.kp.composearc.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(
    val id: Int,
    val title: String,
    val description : String
) : Parcelable