package academy.WS.modules.factory.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "FACTORY")
data class Factory(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var country_code: String

)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Factory

        return id != null && id == other.id
    }
    override fun hashCode(): Int = javaClass.hashCode()
    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , country_code = $country_code )"
    }
}