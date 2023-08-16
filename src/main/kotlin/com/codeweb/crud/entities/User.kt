package com.codeweb.crud.entities

import javax.persistence.*


@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "phone_number")
    val phoneNumber: String,

    @Column(name = "active")
    val active: String = "N",

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var userConfirmationCode: UserConfirmationCode? = null
) {
    constructor() : this(0, "", "", "''''''''''")
}