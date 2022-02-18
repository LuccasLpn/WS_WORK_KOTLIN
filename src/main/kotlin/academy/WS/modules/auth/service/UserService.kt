package academy.WS.modules.auth.service

import academy.WS.modules.auth.domain.User
import academy.WS.modules.auth.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService (val userRepository: UserRepository, val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    fun save(user: User): User {
        user.password = bCryptPasswordEncoder.encode(user.password)
        return this.userRepository.save(user)
    }

}