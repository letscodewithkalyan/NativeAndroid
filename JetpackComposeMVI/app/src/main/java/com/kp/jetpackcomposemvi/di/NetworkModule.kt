package com.kp.jetpackcomposemvi.di

import com.kp.jetpackcomposemvi.data.datasource.network.apis.DataApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseURL() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseURL: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseURL).addConverterFactory(Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType())).build()
    }

    @Provides
    @Singleton
    fun provideDataApi(retrofit: Retrofit): DataApi{
        return retrofit.create(DataApi::class.java)
    }
}