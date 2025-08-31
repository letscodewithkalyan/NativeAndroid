package com.kp.composearc.data.datasources.network.api

import com.kp.composearc.data.datasources.network.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FakerApi {
    @GET("users")
    suspend fun getUsers(@Query("_quantity") quantity: Int, @Query("_page") page: Int): Response<UserDto>
}