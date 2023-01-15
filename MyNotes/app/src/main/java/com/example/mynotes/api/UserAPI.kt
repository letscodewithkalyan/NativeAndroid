package com.example.mynotes.api

import com.example.mynotes.models.UserRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/users/signup")
    suspend fun signup(@Body userRequest: UserRequest)

    @POST("/users/signin")
    suspend fun signin(@Body userRequest: UserRequest)
}