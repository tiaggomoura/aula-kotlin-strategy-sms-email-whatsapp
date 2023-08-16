package com.codeweb.crud.dtos

import com.codeweb.crud.enums.ConfirmationMethodEnum
import com.fasterxml.jackson.annotation.JsonAlias

data class RegistrationRequestDTO(
    @JsonAlias("user")
    val userDto: UserDTO,
    val confirmationMethod: ConfirmationMethodEnum
)