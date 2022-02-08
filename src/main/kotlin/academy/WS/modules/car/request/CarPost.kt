package academy.WS.modules.car.request

import academy.WS.modules.factory.domain.Factory
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Builder
import javax.persistence.*


class CarPost {

    fun factory(savedFactory: Factory?) {
        if (savedFactory != null) {
            savedFactory.id
        }
    }

    var id: Int? = null
    var factoryId: Int? = null
        get(){ return field }
        set(value) { field = value }
    var model: String? = null
    var year: Int? = null
    var fuel: String? = null
    var doors: Int? = null
    var cost: Double? = null
    var color: String? = null




}