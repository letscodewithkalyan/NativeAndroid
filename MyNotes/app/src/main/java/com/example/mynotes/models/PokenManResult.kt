package com.example.mynotes.models

data class PokeManResult(  val count: Long,
                           val next: String?,
                           val previous: String?,
                           val results: List<PokeURL>)

data class PokeURL(val name: String,
                   val url: String,)


