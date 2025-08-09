package com.kp.androidarc.data.datasources.network.models

import com.kp.androidarc.data.models.UserDataModel

data class UserDataDto(
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

fun DataDto.toDomain(): UserDataModel {
    return UserDataModel(
        id = this.id,
        uuid = this.uuid,
        firstname = this.firstname,
        lastname = this.lastname,
        username = this.username,
        password = this.password,
        email = this.email,
        ip = this.ip,
        macAddress = this.macAddress,
        website = this.website,
        image = this.image,
    )
}