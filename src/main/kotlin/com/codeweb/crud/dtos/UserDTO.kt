package com.codeweb.crud.dtos

import com.codeweb.crud.entities.User


data class UserDTO(
    val username: String,
    val email: String,
    val phoneNumber: String
) {
    fun toUser(): User {
        return User(
            name = username,
            email = email,
            phoneNumber = phoneNumber
        )
    }
}
