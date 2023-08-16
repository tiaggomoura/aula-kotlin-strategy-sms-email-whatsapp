package com.codeweb.crud.repostories

import com.codeweb.crud.entities.UserConfirmationCode
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserConfirmationCodeRepository : CrudRepository<UserConfirmationCode, Long> {

    @Query("SELECT ucc FROM UserConfirmationCode ucc JOIN ucc.user user WHERE user.email = :email AND ucc.confirmationCode = :code")
    fun findByEmailAndCode(@Param("email") email: String, @Param("code") code: String): UserConfirmationCode?
}