package com.codeweb.crud.feign.clients

import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(name = "GtiWhatsAppClient", url = "\${message.gti.url}")
interface GtiWhatsAppClient {
    @Headers("accept: */*")
    @GetMapping("/WA/EnviarWA")
    fun sendMessage(
        @RequestParam("email") email: String,
        @RequestParam("token") token: String,
        @RequestParam("id") id: String,
        @RequestParam("mensagem") message: String,
        @RequestParam("numeros") phoneNumbers: String
    )
}