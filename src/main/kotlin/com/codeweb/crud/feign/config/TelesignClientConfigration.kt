package com.codeweb.crud.feign.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.Base64Utils

@Configuration
class TelesignClientConfiguration {
    @Value("\${message.telesign.user.customerId}")
    private lateinit var apiKey: String

    @Value("\${message.telesign.user.apiKey}")
    private lateinit var apiSecret: String

    @Bean
    fun basicAuthRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template: RequestTemplate ->
            val credentials = "$apiKey:$apiSecret"
            val base64Credentials = Base64Utils.encodeToString(credentials.toByteArray())

            template.header("accept", "application/json")
            template.header("content-type", "application/x-www-form-urlencoded")
            template.header("Authorization", "Basic $base64Credentials")
        }
    }
}