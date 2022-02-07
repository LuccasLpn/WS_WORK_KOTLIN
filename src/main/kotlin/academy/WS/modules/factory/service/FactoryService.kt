package academy.WS.modules.factory.service

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.repository.FactoryRepository
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import javax.xml.bind.ValidationException

@Service
class FactoryService (val factoryRepository: FactoryRepository){

    fun save(factory: Factory): Factory {
        validateFactoryNameInformed(factory)
        return factoryRepository.save(factory)
    }

    fun delete(id: Int){
        factoryRepository.delete(findByIdOrThrowBadRequestException(id))
    }

    fun update(factory: Factory){
        validateFactoryNameInformed(factory)
        factory.id?.let { findByIdOrThrowBadRequestException(it) }
        factoryRepository.save(factory)
    }

    fun findByIdOrThrowBadRequestException(id: Int): Factory {
        return factoryRepository.findById(id)
            .orElseThrow { ValidationException("Factory not Found") }
    }

    fun findAll():MutableList<Factory>{
        return factoryRepository.findAll();
    }

    private fun validateFactoryNameInformed(request: Factory){
        if (ObjectUtils.isEmpty(request.name)){
            throw ValidationException("The Factory Name Was Not Informed")
        }
        if (ObjectUtils.isEmpty(request.country_code)){
            throw ValidationException("The Factory CountryCode Was Not Informed")
        }

        if (ObjectUtils.isEmpty(request.id)){
            throw ValidationException("The Factory CountryCode Was Not Informed")
        }

    }



}