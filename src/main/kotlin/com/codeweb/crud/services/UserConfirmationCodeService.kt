package com.codeweb.crud.services

import com.codeweb.crud.entities.User
import com.codeweb.crud.entities.UserConfirmationCode
import com.codeweb.crud.repostories.UserConfirmationCodeRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class UserConfirmationCodeService(
    private val repository: UserConfirmationCodeRepository
) {

    fun createConfirmationCode(user: User) {
        val newConfirmationCode = generateConfirmationCode()
        val userConfirmationCode = UserConfirmationCode(user = user, confirmationCode = newConfirmationCode)
        repository.save(userConfirmationCode)
        user.userConfirmationCode = userConfirmationCode
    }

    private fun generateConfirmationCode(): String {
        val codeLength = 6
        val minCodeValue = 100_000
        val maxCodeValue = 999_999

        val randomNumber = Random.nextInt(minCodeValue, maxCodeValue + 1)
        val confirmationCode = randomNumber.toString().take(codeLength)

        return confirmationCode.padStart(codeLength, '0')

    }

    fun findByEmailAndCode(email: String, code: String): UserConfirmationCode? {
        return repository.findByEmailAndCode(email, code)
    }

}
