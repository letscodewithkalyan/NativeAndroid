package com.kp.composearc.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkChecker @Inject constructor(@ApplicationContext private val context: Context){
    fun isNetworkConnected() : Boolean{
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var network = connectivityManager.activeNetwork ?: return false
        var capability = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}