package com.kp.androidarc.data.datasources.network.api

import com.kp.androidarc.data.datasources.network.models.UserDataDto
import retrofit2.http.GET
import retrofit2.Response

interface FakerApi {
    @GET("users?_quantity=20")
    suspend fun getUsers(): Response<UserDataDto>
}