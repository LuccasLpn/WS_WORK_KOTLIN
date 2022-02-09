package academy.WS.modules.auth.domain

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@AllArgsConstructor
@NoArgsConstructor
@Entity
class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    var username: String? = null

    var email: String? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null



}