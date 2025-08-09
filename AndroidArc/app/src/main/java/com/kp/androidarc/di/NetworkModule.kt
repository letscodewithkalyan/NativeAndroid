package com.kp.androidarc.di

import com.kp.androidarc.core.Constants
import com.kp.androidarc.data.datasources.network.api.FakerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofitBuilder: Retrofit.Builder) : FakerApi {
        return retrofitBuilder.build().create(FakerApi::class.java);
    }
}