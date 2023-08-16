package com.codeweb.crud.services

import com.codeweb.crud.entities.User
import com.codeweb.crud.feign.clients.GtiWhatsAppClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GtiService(
    private val gtiWhatsAppClient: GtiWhatsAppClient
) {

    @Value("\${message.gti.url}")
    private lateinit var gtiUrl: String

    @Value("\${message.gti.token}")
    private lateinit var gtiToken: String

    @Value("\${message.gti.user}")
    private lateinit var gtiUser: String

    fun sendMessage(user: User) {
        val msg = "Olá ${user.name},seu código de confirmação é: "
        val code = user.userConfirmationCode?.confirmationCode
        val id = code + 1

        gtiWhatsAppClient.sendMessage(gtiUser, gtiToken, id, msg.plus(code), user.phoneNumber)

    }

}