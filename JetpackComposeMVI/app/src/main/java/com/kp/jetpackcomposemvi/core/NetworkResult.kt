package com.kp.jetpackcomposemvi.core

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T): NetworkResult<T>()
    data class Error(val errorMesage: String): NetworkResult<Nothing>()
}