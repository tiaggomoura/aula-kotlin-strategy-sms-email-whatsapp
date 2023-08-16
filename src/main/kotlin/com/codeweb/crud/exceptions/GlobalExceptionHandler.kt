package com.codeweb.crud.exceptions

import com.codeweb.crud.dtos.ErrorResponseDTO
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidRequestException(ex: NotFoundException): ErrorResponseDTO {
        return ErrorResponseDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = "Bad Request",
            message = ex.message ?: "Invalid request"
        )
    }

}