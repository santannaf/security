package santannaf.demo.brc.rinha.backend.security.entrypoint

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import santannaf.demo.brc.rinha.backend.security.service.AuthService

@RestController
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("authenticate")
    fun authenticate(authentication: Authentication): ResponseEntity<*> {
        return ResponseEntity.ok(authService.authenticate(authentication))
    }
}
