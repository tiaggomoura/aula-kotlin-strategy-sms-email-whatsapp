package com.codeweb.crud.scheduler

import com.codeweb.crud.services.GoogleAuthenticatorService
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*

private val log = KotlinLogging.logger {}


@Component
class GenerateSecretScheduler(private val googleAuthenticatorService: GoogleAuthenticatorService) {

    @Scheduled(fixedRate = 1_000L)
    fun getCode() {
        val timestamp = Date(System.currentTimeMillis())
        val code = googleAuthenticatorService.getCode(timestamp)
        log.info { "Code: $code" }
    }

}