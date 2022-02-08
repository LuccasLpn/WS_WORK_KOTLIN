package academy.WS.modules.factory.domain

import javax.persistence.*

@Entity
@Table(name = "TB_FACTORY")
class Factory {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null
    var countryCode: Int? = null

}


