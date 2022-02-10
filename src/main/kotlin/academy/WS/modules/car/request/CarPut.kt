package academy.WS.modules.car.request

import academy.WS.modules.factory.domain.Factory

class CarPut {

    fun factory(savedFactory: Factory?) {
        savedFactory?.id
    }

    var factoryId: Int? = null
    var id: Int? = null
    var model: String? = null
    var year: Int? = null
    var fuel: String? = null
    var doors: Int? = null
    var cost: Double? = null
    var color: String? = null

}