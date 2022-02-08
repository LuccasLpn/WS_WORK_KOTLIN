package academy.WS.modules.car.mapper

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.domain.CarPost
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
abstract class CarMapper {

    abstract fun toPost(carPost: CarPost): Car

    companion object {
        var INSTANCE = Mappers.getMapper(CarMapper::class.java)
    }

}