package com.kp.jetpackcomposemvi.data.datasource.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)