package academy.WS.modules.factory.controller

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.service.FactoryService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/factory"])
class FactoryController(val factoryService: FactoryService) {


    @PostMapping(path = ["/save"])
    fun save(@RequestBody factory: Factory) : ResponseEntity < Factory >{
        return ResponseEntity(factoryService.save(factory), HttpStatus.CREATED)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id : Int) : ResponseEntity < Void >{
        factoryService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping(path = ["/findAll"])
    fun findAll() : ResponseEntity < List < Factory >>{
        return ResponseEntity(factoryService.findAll(),HttpStatus.OK)
    }

    @GetMapping(path = ["/findByName"])
    @ResponseBody
    fun findByName(@RequestParam name : String) : ResponseEntity<List<Factory>>{
        return ResponseEntity(factoryService.findByName(name), HttpStatus.OK)
    }



}