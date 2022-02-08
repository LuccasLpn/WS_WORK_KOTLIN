package academy.WS.modules.factory.repository

import academy.WS.modules.factory.domain.Factory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FactoryRepository : JpaRepository<Factory, Int> {

    fun findByNameIgnoreCase(name: String): List<Factory>
    fun findByNameIgnoreCaseContaining(name: String): List<Factory>

}