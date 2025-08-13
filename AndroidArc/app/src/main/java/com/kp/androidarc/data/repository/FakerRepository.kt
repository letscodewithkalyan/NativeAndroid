package com.kp.androidarc.data.repository

import com.kp.androidarc.data.datasources.local.dao.UserDao
import com.kp.androidarc.data.datasources.network.NetworkResult
import com.kp.androidarc.data.datasources.network.api.FakerApi
import com.kp.androidarc.data.datasources.network.dto.toDomain
import com.kp.androidarc.data.models.UserDataModel
import org.json.JSONObject
import javax.inject.Inject

//Best way to place the network and database logic in repository
class FakerRepository @Inject constructor(private  val fakerApi: FakerApi, private val userDao: UserDao) {
    //We can add stateflow here or viewmodel
    //Depending on convience
    suspend fun getUsers() : NetworkResult<List<UserDataModel>>  {
        try {
            val response = fakerApi.getUsers()
            if (response.isSuccessful && response.body() != null) {
                val result = response.body()!!
                var list = mutableListOf<UserDataModel>()
                for (poke in result.data){
                    list.add(poke.toDomain())
                }
              return  NetworkResult.Success(list)
            }else{
                val errorMsg = JSONObject(response.errorBody()?.charStream()?.readText() ?: "")
                    .optString("message", "Unknown error")
                return   NetworkResult.Error(errorMsg)
            }
        }catch (e: Exception){
            return NetworkResult.Error("Network failure: ${e.message}")
        }
    }
}