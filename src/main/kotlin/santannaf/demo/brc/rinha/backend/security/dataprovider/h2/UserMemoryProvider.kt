package santannaf.demo.brc.rinha.backend.security.dataprovider.h2

import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository
import santannaf.demo.brc.rinha.backend.security.entity.User
import santannaf.demo.brc.rinha.backend.security.provider.UserProvider

@Repository
class UserMemoryProvider(
    private val jdbcClient: JdbcClient
) : UserProvider {
    override fun findByUsername(username: String): User? {
        return jdbcClient.sql("select * from users where username = :username")
            .param("username", username)
            .query(User::class.java)
            .optional().orElse(null)
    }
}
