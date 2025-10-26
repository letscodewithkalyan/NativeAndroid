package com.kp.jetpackcomposemvi.data.mapper

import com.kp.jetpackcomposemvi.data.datasource.network.dtos.UserDto
import com.kp.jetpackcomposemvi.data.model.UserModel

fun UserDto.toModel(): UserModel {
    return UserModel(
        id = id,
        email = email,
        name = name,
        phone = phone,
        username = username,
        website = website
    )
}