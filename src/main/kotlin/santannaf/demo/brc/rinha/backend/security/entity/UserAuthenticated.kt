package santannaf.demo.brc.rinha.backend.security.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserAuthenticated(
    val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return emptyList()
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.username
    }
}
