package academy.WS.modules.car.domain

import academy.WS.modules.factory.domain.Factory
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Builder
import javax.persistence.*

@Entity
@Table(name = "TB_CAR")
class Car {


    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "FACTORY_ID", referencedColumnName = "id")
    @JsonIgnore
    var factory: Factory = Factory()
        get(){ return field }
        set(value) { field = value }
    @Column(name = "MODELO")
    var model: String? = null
        get(){ return field }
        set(value) { field = value }
    @Column(name = "ANO")
    var year: Int? = null
        get(){ return field }
        set(value) { field = value }
    @Column(name = "COMBUSTIVEL")
    var fuel: String? = null
        get(){ return field }
        set(value) { field = value }
    @Column(name = "NUM_PORTAS")
    var doors: Int? = null
        get(){ return field }
        set(value) { field = value }
    @Column(name = "VALOR_FIPE")
    var cost: Double? = null
        get(){ return field }
        set(value) { field = value }
    @Column(name = "COR")
    var color: String? = null
        get(){ return field }
        set(value) { field = value }


}