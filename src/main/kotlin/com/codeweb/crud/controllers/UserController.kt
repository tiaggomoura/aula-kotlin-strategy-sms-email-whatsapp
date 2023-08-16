package com.codeweb.crud.controllers

import com.codeweb.crud.dtos.RegistrationRequestDTO
import com.codeweb.crud.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun registerUser(@Valid @RequestBody request: RegistrationRequestDTO) {
        userService.registerUser(request.userDto.toUser(), request.confirmationMethod)
    }

    @GetMapping("/validate")
    fun validateConfirmationCode(
        @RequestParam email: String,
        @RequestParam code: String
    ): ResponseEntity<Any> {
        val isValid = userService.validateConfirmationCode(email, code)
        return if (isValid) {
            ResponseEntity.accepted().build()
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The code has expired, please request another one.")
        }
    }
}