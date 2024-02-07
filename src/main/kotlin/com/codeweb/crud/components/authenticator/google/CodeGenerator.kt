package com.codeweb.crud.components.authenticator.google

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import dev.turingcomplete.kotlinonetimepassword.HmacAlgorithm
import dev.turingcomplete.kotlinonetimepassword.OtpAuthUriBuilder
import dev.turingcomplete.kotlinonetimepassword.RandomSecretGenerator
import org.bouncycastle.util.encoders.Base32
import org.springframework.stereotype.Component
import java.awt.image.BufferedImage

@Component
class CodeGenerator(private val writer: QRCodeWriter) {

    private final val randomSecretGenerator = RandomSecretGenerator()
    val secret: ByteArray = randomSecretGenerator.createRandomSecret(HmacAlgorithm.SHA256)

    fun generate(issuer: String, email: String): BufferedImage {

        val uriTotp = OtpAuthUriBuilder.forTotp(Base32.encode(secret))
            .label(email, issuer)
            .issuer(issuer)
            .digits(6)
            .buildToString()

        val matrix = writer.encode(uriTotp, BarcodeFormat.QR_CODE, 200, 200)
        return MatrixToImageWriter.toBufferedImage(matrix)

    }


}