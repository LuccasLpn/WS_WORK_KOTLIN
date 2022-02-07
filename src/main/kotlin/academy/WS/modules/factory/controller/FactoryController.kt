package academy.WS.modules.factory.controller

import academy.WS.modules.factory.service.FactoryService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping( "/api/factory")
@RequiredArgsConstructor
class FactoryController {

    lateinit var factoryService: FactoryService

}