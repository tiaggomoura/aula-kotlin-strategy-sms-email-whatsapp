package com.codeweb.crud.feign.config

import feign.Logger
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignConfig {

    @Bean
    fun feignContract() = SpringMvcContract()

    @Bean
    fun logLevel() = Logger.Level.FULL

    @Bean
    fun log(): Logger = Slf4jLogger()

}