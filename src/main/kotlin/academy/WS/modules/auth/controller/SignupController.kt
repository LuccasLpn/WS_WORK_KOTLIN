package academy.WS.modules.auth.controller

import academy.WS.modules.auth.domain.User
import academy.WS.modules.auth.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid


@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/user"])
class SignupController (val userService: UserService){


    @PostMapping(path = ["/save"])
    fun saveUser(@RequestBody @Valid user: User): ResponseEntity<User>{
        return ResponseEntity(userService.save(user), HttpStatus.CREATED)
    }



}