package com.example.mynotes.repository.api

import com.example.mynotes.models.PokeManResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokeAPI {
    @GET
    suspend fun getPokeResult(@Url fullURL: String) : Response<PokeManResult>
}