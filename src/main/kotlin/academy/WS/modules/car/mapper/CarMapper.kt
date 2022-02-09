package academy.WS.modules.car.mapper

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.request.CarPost
import academy.WS.modules.car.request.CarPut
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
abstract class CarMapper {

    abstract fun toPost(carPost: CarPost): Car
    abstract fun toPut(carPut: CarPut): Car

    companion object {
        var INSTANCE = Mappers.getMapper(CarMapper::class.java)
    }

}