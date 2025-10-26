package com.kp.jetpackcomposemvi.data.repository

import com.kp.jetpackcomposemvi.core.NetworkResult
import com.kp.jetpackcomposemvi.data.datasource.network.apis.DataApi
import com.kp.jetpackcomposemvi.data.mapper.toModel
import com.kp.jetpackcomposemvi.data.model.UserModel
import org.json.JSONObject
import javax.inject.Inject

class DataRepository @Inject constructor(private val dataApi: DataApi) {

    suspend fun getUsers(): NetworkResult<List<UserModel>> {
        try {
            var response = dataApi.GetUsers()
            if (response.isSuccessful) {
                var usersList = mutableListOf<UserModel>()
                response.body()?.let {
                    for (user in it) {
                        usersList.add(user.toModel())
                    }
                }
                return NetworkResult.Success(usersList)
            } else {
                var errorMessage = JSONObject(
                    response.errorBody()?.charStream()?.readText() ?: ""
                ).optString("message", "Unknown error")
                return NetworkResult.Error(errorMessage)
            }
        } catch (ex: Exception) {
            return NetworkResult.Error("Error ${ex.message}")
        }
    }
}