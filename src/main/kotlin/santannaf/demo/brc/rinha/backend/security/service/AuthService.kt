package santannaf.demo.brc.rinha.backend.security.service

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val jwtService: JWTService
) {
    fun authenticate(authenticate: Authentication): String {
        return jwtService.generateTokenJWT(authenticate)
    }
}
