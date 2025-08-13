package com.kp.composearc.data.mapper

import com.kp.composearc.data.datasources.network.dto.DataDto
import com.kp.composearc.data.datasources.network.dto.UserDto
import com.kp.composearc.data.model.UserModel

fun DataDto.toUserModel(): UserModel {
    return UserModel(
        id = this.id,
        firstname = this.firstname,
        lastname = this.lastname,
        username = this.username,
        password = this.password,
        email = this.email,
        website = this.website,
        image = this.image
    )
}