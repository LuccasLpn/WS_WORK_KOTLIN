package academy.WS.modules.car.service

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.domain.CarPost
import academy.WS.modules.car.mapper.CarMapper
import academy.WS.modules.car.repository.CarRepository
import academy.WS.modules.factory.service.FactoryService
import org.springframework.stereotype.Service

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



}
