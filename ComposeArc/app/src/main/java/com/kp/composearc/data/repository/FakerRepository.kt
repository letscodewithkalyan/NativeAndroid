package com.kp.composearc.data.repository

import com.google.gson.Gson
import com.kp.composearc.data.datasources.network.NetworkResult
import com.kp.composearc.data.datasources.network.api.FakerApi
import com.kp.composearc.data.mapper.toUserModel
import com.kp.composearc.data.model.UserModel
import org.json.JSONObject
import javax.inject.Inject

class FakerRepository @Inject constructor(private val fakerApi: FakerApi) {
    suspend fun getUsers(): NetworkResult<List<UserModel>> {
        try {
            val response = fakerApi.getUsers()
            if(response.isSuccessful && response.body() != null){
                val result = response.body()!!
                var list = mutableListOf<UserModel>()
                for (poke in result.data){
                    list.add(poke.toUserModel())
                }
                return  NetworkResult.Success(list)
            }
            val errorMsg = JSONObject(response.errorBody()?.charStream()?.readText() ?: "")
                .optString("message", "Unknown error")
            return   NetworkResult.Error(errorMsg)
        } catch (e: Exception) {
            return NetworkResult.Error("Network failure: ${e.message}")
        }
    }
}