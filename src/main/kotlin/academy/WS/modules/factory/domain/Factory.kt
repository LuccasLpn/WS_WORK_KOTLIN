package academy.WS.modules.factory.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "TB_FACTORY")
class Factory {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
        get(){ return field }
        set(value) { field = value }
    var name: String? = null
        get(){ return field }
        set(value) { field = value }
    var country_code: String? = null
        get(){ return field }
        set(value) { field = value }

}


