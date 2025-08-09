package com.kp.androidarc.data.models

data class UserDataModel(
    val id: Long,
    val uuid: String,
    val firstname: String,
    val lastname: String,
    val username: String,
    val password: String,
    val email: String,
    val ip: String,
    val macAddress: String,
    val website: String,
    val image: String,
)