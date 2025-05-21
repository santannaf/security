package santannaf.demo.brc.rinha.backend.security.provider

import santannaf.demo.brc.rinha.backend.security.entity.User

interface UserProvider {
    fun findByUsername(username: String): User?
}
