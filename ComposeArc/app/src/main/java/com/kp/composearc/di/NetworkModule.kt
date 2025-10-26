package com.kp.composearc.di

import android.content.Context
import androidx.core.util.Consumer
import com.kp.composearc.core.Constants
import com.kp.composearc.data.datasources.network.AuthInterceptor
import com.kp.composearc.data.datasources.network.api.FakerApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun providesCache(@ApplicationContext context: Context): Cache {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        return Cache(File(context.cacheDir, "http_cache"), cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder().cache(cache).addInterceptor(authInterceptor).build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
            //.addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofitBuilder: Retrofit): FakerApi {
        return retrofitBuilder.create(FakerApi::class.java)
    }
}