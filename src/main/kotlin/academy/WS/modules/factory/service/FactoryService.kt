package academy.WS.modules.factory.service

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.domain.mapper.FactoryMapper
import academy.WS.modules.factory.repository.FactoryRepository
import academy.WS.modules.factory.request.FactoryPost
import academy.WS.modules.factory.request.FactoryPut
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import javax.xml.bind.ValidationException

@Service
class FactoryService (val factoryRepository: FactoryRepository){

    fun save(factoryPost: FactoryPost): Factory {
        validateFactoryNameInformed(factoryPost)
        return factoryRepository.save(FactoryMapper.INSTANCE.toPost(factoryPost))
    }

    fun delete(id: Int){
        factoryRepository.delete(findByIdOrThrowBadRequestException(id))
    }

    fun update(factoryPut: FactoryPut): Unit{
        factoryPut.id?.let { findByIdOrThrowBadRequestException(it) }
        val factory = FactoryMapper.INSTANCE.toPut(factoryPut)
        factory.id = factoryPut.id
        factoryRepository.save(factory)
    }

    fun findByIdOrThrowBadRequestException(id: Int): Factory {
        return factoryRepository.findById(id)
            .orElseThrow { ValidationException("Factory not Found") }
    }

    fun findAll():MutableList<Factory>{
        return factoryRepository.findAll();
    }

    fun findByName(name: String): List<Factory> {
        return factoryRepository.findByNameIgnoreCase(name)
    }
    fun findByNameContaining(name: String): List<Factory> {
        return factoryRepository.findByNameIgnoreCaseContaining(name)
    }

    fun findByCode(code: Int): List<Factory>{
        return factoryRepository.findByCountryCode(code)
    }

    private fun validateFactoryNameInformed(request: FactoryPost){
        if (ObjectUtils.isEmpty(request.name)){
            throw ValidationException("The Factory Name Was Not Informed")
        }
        if (ObjectUtils.isEmpty(request.countryCode)){
            throw ValidationException("The Factory CountryCode Was Not Informed")
        }

    }



}