package academy.WS.modules.auth.controller

import academy.WS.modules.auth.domain.User
import academy.WS.modules.auth.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/user"])
class AuthController (private val userService: UserService){


    @PostMapping(path = ["/save"])
    fun saveUser(@RequestBody @Valid user: User): ResponseEntity<User>{
        return ResponseEntity(this.userService.save(user), HttpStatus.CREATED)
    }

}