package santannaf.demo.brc.rinha.backend.security.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import santannaf.demo.brc.rinha.backend.security.entity.UserAuthenticated
import santannaf.demo.brc.rinha.backend.security.provider.UserProvider

@Service
class UserDetailsServiceImpl(
    private val userProvider: UserProvider
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userProvider.findByUsername(username) ?: throw UsernameNotFoundException("User not found")
        return UserAuthenticated(user)
    }
}
