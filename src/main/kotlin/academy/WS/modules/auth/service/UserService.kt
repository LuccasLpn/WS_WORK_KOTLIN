package academy.WS.modules.auth.service

import academy.WS.modules.auth.domain.User
import academy.WS.modules.auth.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@RequiredArgsConstructor
class UserService (private val userRepository: UserRepository){


    @Transactional
    fun save(user: User): User{
        user.password = passwordEncoder.encode(user.password)
        return this.userRepository.save(user)
    }


    @get:Bean
    val passwordEncoder: PasswordEncoder
        get() = BCryptPasswordEncoder()

}