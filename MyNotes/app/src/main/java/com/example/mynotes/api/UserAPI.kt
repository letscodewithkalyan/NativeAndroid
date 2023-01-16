package com.example.mynotes.api

import com.example.mynotes.models.UserRequest
import com.example.mynotes.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/login ")
    suspend fun signup(@Body userRequest: UserRequest) : Response<UserResponse>

    @POST("/login")
    suspend fun signin(@Body userRequest: UserRequest) : Response<UserResponse>
}