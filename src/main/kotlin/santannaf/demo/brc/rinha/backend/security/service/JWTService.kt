package santannaf.demo.brc.rinha.backend.security.service

import java.time.Instant
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service

@Service
class JWTService(
    private val encoder: JwtEncoder
) {
    fun generateTokenJWT(authentication: Authentication): String {
        val now = Instant.now()
        val expiry = now.plusSeconds(60 * 60)
        val scopes = authentication.authorities.joinToString(" ") { it.authority }
        val claims = JwtClaimsSet.builder()
            .issuer("security")
            .issuedAt(now)
            .expiresAt(expiry)
            .subject(authentication.name)
            .claim("scopes", scopes)
            .build()

        return encoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }

}
