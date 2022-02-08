package academy.WS.modules.car.controller

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.domain.CarPost
import academy.WS.modules.car.service.CarService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/car"])
class CarController(val carService: CarService) {


    @PostMapping(path = ["/save"])
    fun save(@RequestBody @Valid carPost: CarPost): ResponseEntity<Car>{
        return ResponseEntity(carService.save(carPost), HttpStatus.CREATED)
    }

}