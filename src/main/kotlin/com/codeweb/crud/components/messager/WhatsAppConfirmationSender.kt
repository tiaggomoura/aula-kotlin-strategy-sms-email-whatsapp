package com.codeweb.crud.components.messager

import com.codeweb.crud.entities.User
import com.codeweb.crud.intefaces.IConfirmationSender
import com.codeweb.crud.services.GtiService
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class WhatsAppConfirmationSender(private val gtiService: GtiService) : IConfirmationSender {
    override fun sendConfirmation(user: User) {
        gtiService.sendMessage(user)
        log.info { "Seu código WhatsApp para ativação é: ${user.userConfirmationCode?.confirmationCode} " }
    }
}