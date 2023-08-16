package com.codeweb.crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CrudApplication

fun main(args: Array<String>) {
    runApplication<CrudApplication>(*args)
}
