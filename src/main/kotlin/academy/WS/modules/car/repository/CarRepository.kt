package academy.WS.modules.car.repository

import academy.WS.modules.car.domain.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository: JpaRepository<Car,Int> {

    fun findByCost(coost: Double): List<Car>
    fun findByColorIgnoreCase(cor: String): List<Car>
    fun findByModel(model: String): List<Car>
    fun findByYear(year: Int): List<Car>

}