package com.kp.androidarc.data.datasources.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request  = chain.request().newBuilder()
        //add token
        return chain.proceed(request.build());
    }
}