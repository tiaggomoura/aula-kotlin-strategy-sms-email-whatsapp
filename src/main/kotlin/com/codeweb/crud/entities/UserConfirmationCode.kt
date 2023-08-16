package com.codeweb.crud.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users_confirmation_code")
data class UserConfirmationCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "confirmation_code")
    val confirmationCode: String?,

    @Column(name = "creation_time")
    val creationTime: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User?,
) {
    fun isValid(): Boolean {
        val expirationLimit = creationTime.plusHours(1) // limite de validade de 1 hora
        val currentTime = LocalDateTime.now()
        return currentTime.isBefore(expirationLimit)
    }
}
