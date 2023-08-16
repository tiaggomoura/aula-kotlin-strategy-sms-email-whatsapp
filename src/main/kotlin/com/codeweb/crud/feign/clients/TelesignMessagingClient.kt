package com.codeweb.crud.feign.clients


import com.codeweb.crud.feign.config.TelesignClientConfiguration
import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping


@FeignClient(
    name = "telesignClient",
    url = "\${message.telesign.url.sms}",
    configuration = [TelesignClientConfiguration::class]
)
interface TelesignMessagingClient {
    @PostMapping("/messaging")
    @Headers("Content-Type: application/x-www-form-urlencoded; accept: application/json ; charset=utf-8")
    fun sendSMS(requestBody: String)
}