package academy.WS.modules.factory.controller

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.request.FactoryPost
import academy.WS.modules.factory.request.FactoryPut
import academy.WS.modules.factory.service.FactoryService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/factory"])
class FactoryController(val factoryService: FactoryService) {

    @PostMapping(path = ["/save"])
    fun save(@RequestBody @Valid factoryPost: FactoryPost) : ResponseEntity <Factory>{
        return ResponseEntity(factoryService.save(factoryPost), HttpStatus.CREATED)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody factoryPut: FactoryPut): ResponseEntity<Factory>{
        factoryService.update(factoryPut)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id : Int) : ResponseEntity < Void >{
        factoryService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping(path = ["/findAll"])
    fun findAll() : ResponseEntity < List <Factory>>{
        return ResponseEntity(factoryService.findAll(),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByName/{name}"])
    fun findByName(@PathVariable name: String):ResponseEntity <List<Factory>>{
        return ResponseEntity(factoryService.findByName(name),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByNameContaining/{name}"])
    fun findByNameContaining(@PathVariable name: String):ResponseEntity <List<Factory>>{
        return ResponseEntity(factoryService.findByNameContaining(name),HttpStatus.OK)
    }

    @GetMapping(path = ["/findById/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Factory>{
        return ResponseEntity.ok(factoryService.findByIdOrThrowBadRequestException(id))
    }

    @GetMapping(path = ["/findByCode/{code}"])
    fun findByCode(@PathVariable code: Int):ResponseEntity <List<Factory>>{
        return ResponseEntity(factoryService.findByCode(code),HttpStatus.OK)
    }



}