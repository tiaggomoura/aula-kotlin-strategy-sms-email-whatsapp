package com.codeweb.crud.services

import com.codeweb.crud.entities.User
import com.codeweb.crud.enums.ConfirmationMethodEnum
import com.codeweb.crud.exceptions.NotFoundException
import com.codeweb.crud.repostories.UserRepository
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val userConfirmationCodeService: UserConfirmationCodeService,
    private val ctx: ApplicationContext
) {


    fun registerUser(user: User, confirmationMethod: ConfirmationMethodEnum) {

        val userSaved = repository.save(user)

        userConfirmationCodeService.createConfirmationCode(userSaved)

        confirmationMethod.sendConfirmation(userSaved, ctx)

    }


    fun findByEmailAndCode(email: String, code: String): User? {
        val userConfirmationCode = userConfirmationCodeService.findByEmailAndCode(email, code)
            ?: throw NotFoundException("Usuário ou código não encontrado(s)")

        return userConfirmationCode.user
    }

    fun validateConfirmationCode(email: String, code: String): Boolean {
        val user = findByEmailAndCode(email, code)
        return user?.userConfirmationCode?.isValid() == true
    }

}