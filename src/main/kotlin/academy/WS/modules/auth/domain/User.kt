package academy.WS.modules.auth.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
class User {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column
    var name: String? = null

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null


}