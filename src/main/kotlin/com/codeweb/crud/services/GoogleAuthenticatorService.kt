package com.codeweb.crud.services

import com.codeweb.crud.components.authenticator.google.CodeGenerator
import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import org.bouncycastle.util.encoders.Base32
import org.springframework.stereotype.Service
import java.util.*

@Service
class GoogleAuthenticatorService(private val generator: CodeGenerator) {

    fun getCode(timestamp: Date): String {
        return GoogleAuthenticator(Base32.encode(generator.secret)).generate(timestamp)
    }

    fun generateCode(issuer: String, email: String) = generator.generate(issuer, email)

}