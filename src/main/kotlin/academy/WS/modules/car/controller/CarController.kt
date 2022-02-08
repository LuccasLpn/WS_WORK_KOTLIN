package academy.WS.modules.car.controller

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.request.CarPost
import academy.WS.modules.car.request.CarPut
import academy.WS.modules.car.service.CarService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/car"])
class CarController(val carService: CarService) {


    @PostMapping(path = ["/save"])
    fun save(@RequestBody @Valid carPost: CarPost): ResponseEntity<Car>{
        return ResponseEntity(carService.save(carPost), HttpStatus.CREATED)
    }


    @PutMapping(path = ["/update"])
    fun update(@RequestBody carPut: CarPut): ResponseEntity<Car>{
        return ResponseEntity(carService.update(carPut), HttpStatus.NO_CONTENT)
    }

}