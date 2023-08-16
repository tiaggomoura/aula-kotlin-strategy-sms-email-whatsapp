package com.codeweb.crud.intefaces

import com.codeweb.crud.entities.User

interface IConfirmationSender {

    fun sendConfirmation(user: User)
}