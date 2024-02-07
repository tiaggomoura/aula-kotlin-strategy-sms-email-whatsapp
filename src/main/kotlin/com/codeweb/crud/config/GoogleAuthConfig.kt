package com.codeweb.crud.config

import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.BufferedImageHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import java.awt.image.BufferedImage

@Configuration
class GoogleAuthConfig {

    @Bean
    fun qrCodeWriter() = QRCodeWriter()

    @Bean
    fun imageConverter(): HttpMessageConverter<BufferedImage> {
        return BufferedImageHttpMessageConverter()
    }
}