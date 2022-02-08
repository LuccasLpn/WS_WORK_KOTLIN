package academy.WS.modules.car.service

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.domain.CarPost
import academy.WS.modules.car.mapper.CarMapper
import academy.WS.modules.car.repository.CarRepository
import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.service.FactoryService
import org.springframework.stereotype.Service
import javax.xml.bind.ValidationException

@Service
class CarService(val carRepository: CarRepository, val factoryService: FactoryService){



    fun save(carPost: CarPost): Car{
        val factoryId = carPost.factoryId?.let { factoryService.findByIdOrThrowBadRequestException(it) }
        val car = CarMapper.INSTANCE.toPost(carPost)
        if (factoryId != null) {
            car.factory = factoryId
        }
        return carRepository.save(car)
    }
    
    fun delete(id: Int){
        carRepository.delete(findByIdOrThrowBadRequestException(id))
    }

    fun findByIdOrThrowBadRequestException(id: Int): Car{
        return carRepository.findById(id)
            .orElseThrow { ValidationException("Car not Found") }
    }

    fun findAll():MutableList<Car>{
        return carRepository.findAll()
    }




}
