package com.kp.jetpackcomposemvi.data.datasource.network.apis

import com.kp.jetpackcomposemvi.data.datasource.network.dtos.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {
    @GET("users")
    suspend fun GetUsers(): Response<List<UserDto>>
}