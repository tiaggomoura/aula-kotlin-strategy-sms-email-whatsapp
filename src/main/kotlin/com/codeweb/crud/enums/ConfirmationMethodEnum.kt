package com.codeweb.crud.enums

import com.codeweb.crud.components.messager.EmailConfirmationSender
import com.codeweb.crud.components.messager.SmsConfirmationSender
import com.codeweb.crud.components.messager.WhatsAppConfirmationSender
import com.codeweb.crud.entities.User
import com.codeweb.crud.services.EmailService
import com.codeweb.crud.services.GtiService
import com.codeweb.crud.services.TelesignService
import org.springframework.context.ApplicationContext

enum class ConfirmationMethodEnum {
    SMS,
    EMAIL,
    WA;

    fun sendConfirmation(user: User, ctx: ApplicationContext) {
        when (this) {
            SMS -> {
                val sender = SmsConfirmationSender(ctx.getBean(TelesignService::class.java))
                sender.sendConfirmation(user)
            }

            EMAIL -> {
                val sender = EmailConfirmationSender(ctx.getBean(EmailService::class.java))
                sender.sendConfirmation(user)
            }

            WA -> {
                val sender = WhatsAppConfirmationSender(ctx.getBean(GtiService::class.java))
                sender.sendConfirmation(user)
            }
        }
    }
}