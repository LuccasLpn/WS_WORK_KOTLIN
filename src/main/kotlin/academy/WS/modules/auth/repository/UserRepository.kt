package academy.WS.modules.auth.repository

import academy.WS.modules.auth.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {

    fun findByEmail(email: String?): User?
    fun findByEmailAndPassword(email: String,password: String): User


}