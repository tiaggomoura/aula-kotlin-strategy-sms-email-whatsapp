package com.codeweb.crud.components.messager

import com.codeweb.crud.entities.User
import com.codeweb.crud.intefaces.IConfirmationSender
import com.codeweb.crud.services.TelesignService
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class SmsConfirmationSender(private val telesignService: TelesignService) : IConfirmationSender {
    override fun sendConfirmation(user: User) {
        telesignService.sendSMS(user)
        log.info { "Seu código SMS para ativação é: ${user.userConfirmationCode?.confirmationCode} " }
    }


}