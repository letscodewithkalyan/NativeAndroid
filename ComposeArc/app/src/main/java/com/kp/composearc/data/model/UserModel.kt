package com.kp.composearc.data.model

data class UserModel(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val username: String,
    val password: String,
    val email: String,
    val website: String,
    val image: String,
)