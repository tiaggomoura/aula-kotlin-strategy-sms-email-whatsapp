package com.codeweb.crud.dtos

data class ErrorResponseDTO(
    val status: Int,
    val error: String,
    val message: String
)
