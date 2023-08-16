package com.codeweb.crud.components.messager

import com.codeweb.crud.entities.User
import com.codeweb.crud.intefaces.IConfirmationSender
import com.codeweb.crud.services.EmailService
import org.springframework.stereotype.Component

@Component
class EmailConfirmationSender(private val emailService: EmailService) : IConfirmationSender {
    override fun sendConfirmation(user: User) {
        emailService.sendEmail(user)
    }
}