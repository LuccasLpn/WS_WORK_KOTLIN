package academy.WS.modules.factory.domain.mapper

import academy.WS.modules.factory.domain.Factory
import academy.WS.modules.factory.request.FactoryPost
import academy.WS.modules.factory.request.FactoryPut
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
abstract class FactoryMapper {

    abstract fun toPost(factoryPost: FactoryPost): Factory
    abstract fun toPut(factoryPut: FactoryPut): Factory


    companion object {
        var INSTANCE = Mappers.getMapper(FactoryMapper::class.java)
    }

}