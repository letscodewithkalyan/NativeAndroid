package com.kp.composearc.data.datasources.network.dto


data class UserDto(
    val status: String,
    val code: Long,
    val locale: String,
    val seed: Any?,
    val total: Long,
    val data: List<DataDto>,
)

data class DataDto(
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