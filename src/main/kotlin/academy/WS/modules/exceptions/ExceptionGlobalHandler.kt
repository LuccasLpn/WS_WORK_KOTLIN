package academy.WS.modules.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionGlobalHandler {

    @ExceptionHandler(ValidationException::class)
    fun handlerValidationException(validationException: ValidationException): ResponseEntity<*> {
        val details = ExceptionDetails()
        details.status = HttpStatus.BAD_REQUEST.value()
        details.message = validationException.message
        return ResponseEntity(details, HttpStatus.BAD_REQUEST)
    }
}