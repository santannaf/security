package santannaf.demo.brc.rinha.backend.security.entrypoint

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/private"])
class PrivateController {
    @GetMapping
    fun getMessagePrivate(): ResponseEntity<*> {
        return ResponseEntity.ok("Hello, private!")
    }
}
