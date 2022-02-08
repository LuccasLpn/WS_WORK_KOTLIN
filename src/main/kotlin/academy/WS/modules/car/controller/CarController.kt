package academy.WS.modules.car.controller

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.request.CarPost
import academy.WS.modules.car.request.CarPut
import academy.WS.modules.car.service.CarService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartException
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid
import javax.validation.ValidationException

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

    @GetMapping(path = ["/findAll"])
    fun findAll() :ResponseEntity<List<Car>>{
        return ResponseEntity(carService.findAll(),HttpStatus.OK)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id: Int): ResponseEntity<Unit>{
        carService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PostMapping(path = ["/save/upload"])
    fun uploadData(@RequestParam("file") file:MultipartFile): String{
        return try {
            carService.upload(file)
        } catch (e: MultipartException) {
            throw ValidationException("File Format")
        }
    }

}