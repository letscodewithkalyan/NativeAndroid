package com.kp.composearc.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FruitModel (
    val name: String,
    val imageUrl: String,
    val description: String,
    val color: String
) : Parcelable