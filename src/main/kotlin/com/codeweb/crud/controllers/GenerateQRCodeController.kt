package com.codeweb.crud.controllers

import com.codeweb.crud.services.GoogleAuthenticatorService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage

@RestController
@RequestMapping("/qrcode")
class GenerateQRCodeController(private val service: GoogleAuthenticatorService) {

    @GetMapping("/generate/{issuer}/{email}", produces = [MediaType.IMAGE_PNG_VALUE])
    fun generate(
        @PathVariable issuer: String,
        @PathVariable email: String,
    ): BufferedImage {
        return service.generateCode(issuer, email)
    }
}