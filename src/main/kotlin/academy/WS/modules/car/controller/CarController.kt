package academy.WS.modules.car.controller

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.request.CarPost
import academy.WS.modules.car.request.CarPut
import academy.WS.modules.car.service.CarService
import io.swagger.v3.oas.annotations.Operation
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
class CarController(val service: CarService) {


    @PostMapping(path = ["/save"])
    fun save(@RequestBody @Valid carPost: CarPost): ResponseEntity<Car>{
        return ResponseEntity(service.save(carPost), HttpStatus.CREATED)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody carPut: CarPut): ResponseEntity<Car>{
        return ResponseEntity(service.update(carPut), HttpStatus.NO_CONTENT)
    }

    @GetMapping(path = ["/findAll"])
    fun findAll() :ResponseEntity<List<Car>>{
        return ResponseEntity(service.findAll(),HttpStatus.OK)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id: Int): ResponseEntity<Unit>{
        service.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }


    @Operation(
        summary = "Upload CSV/XLSX", description = "ID-MARCA_ID-MARCA_NOME-MODELO-ANO-COMBUSTIVEL-NUM_PORTAS-VALOR_FIPE-COR"
    )
    @PostMapping(path = ["/save/upload"])
    fun uploadData(@RequestParam("file") file: MultipartFile): String{
        return try {
            service.upload(file)
        } catch (e: MultipartException) {
            throw ValidationException("File Format Not Supported")
        }
    }


    @GetMapping(path = ["/findById/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Car>{
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id))
    }

    @GetMapping(path = ["/findByCost/{cost}"])
    fun findByCost(@PathVariable cost: Double): ResponseEntity<List<Car>>{
        return ResponseEntity(service.findByCost(cost),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByCor/{cor}"])
    fun findByCor(@PathVariable cor: String): ResponseEntity<List<Car>>{
        return ResponseEntity(service.findByCor(cor),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByModel/{model}"])
    fun findByModel(@PathVariable model:String): ResponseEntity<List<Car>>{
        return ResponseEntity(service.findByModel(model),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByYear/{year}"])
    fun findByYear(@PathVariable year: Int): ResponseEntity<List<Car>>{
        return ResponseEntity(service.findByYear(year),HttpStatus.OK)
    }

}