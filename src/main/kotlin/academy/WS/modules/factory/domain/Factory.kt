package academy.WS.modules.factory.domain

import lombok.Data
import javax.persistence.*

@Entity
@Data
@Table(name = "FACTORY")
data class Factory(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var name: String,
    var countryCode: Long



    )