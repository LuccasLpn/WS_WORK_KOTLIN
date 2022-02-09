package academy.WS.modules.auth.service

import academy.WS.modules.auth.domain.UserDetailsImpl
import academy.WS.modules.auth.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserServiceImpl : UserDetailsService{


    private lateinit var userRepository: UserRepository


    override fun loadUserByUsername(email: String?): UserDetails {
        val user = email?.let { userRepository.findByEmail(it) } ?: throw UsernameNotFoundException(email)
        return UserDetailsImpl(user)
    }

}