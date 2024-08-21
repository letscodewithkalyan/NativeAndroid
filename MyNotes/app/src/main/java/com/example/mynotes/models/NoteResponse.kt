package com.example.mynotes.models

data class NoteResponse(
    val description: String,
    val title: String
){
    override fun hashCode(): Int {
        return super.hashCode()
    }


}