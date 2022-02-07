package academy.WS.modules.factory.service

import academy.WS.modules.factory.repository.FactoryRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class FactoryService {


    lateinit var factoryRepository: FactoryRepository

    
}