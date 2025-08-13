package com.kp.composearc.data.datasources.network.api

import com.kp.composearc.data.datasources.network.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {
    @GET("users?_quantity=20")
    suspend fun getUsers(): Response<UserDto>
}