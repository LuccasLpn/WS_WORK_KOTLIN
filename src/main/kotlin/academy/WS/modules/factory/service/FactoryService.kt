package academy.WS.modules.factory.service

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.repository.FactoryRepository
import org.springframework.stereotype.Service
import javax.xml.bind.ValidationException

@Service
class FactoryService (val factoryRepository: FactoryRepository){

    fun save(factory: Factory): Factory {
        return factoryRepository.save(factory)
    }

    fun delete(id: Int){
        factoryRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    private fun findByIdOrThrowBadRequestException(id: Int): Factory {
        return factoryRepository.findById(id)
            .orElseThrow { ValidationException("Factory not Found") }
    }
    
    fun findAll():MutableList<Factory>{
        return factoryRepository.findAll();
    }

}