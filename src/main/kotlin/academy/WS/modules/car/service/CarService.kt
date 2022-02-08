package academy.WS.modules.car.service

import academy.WS.modules.car.domain.Car
import academy.WS.modules.car.mapper.CarMapper
import academy.WS.modules.car.repository.CarRepository
import academy.WS.modules.car.request.CarPost
import academy.WS.modules.car.request.CarPut
import academy.WS.modules.factory.service.FactoryService
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.function.Consumer
import javax.xml.bind.ValidationException

@Service
class CarService(val carRepository: CarRepository, val factoryService: FactoryService){



    fun save(carPost: CarPost): Car{
        validateCarInformed(carPost)
        val factoryId = carPost.factoryId?.let { factoryService.findByIdOrThrowBadRequestException(it) }
        val car = CarMapper.INSTANCE.toPost(carPost)
        if (factoryId != null) {
            car.factory = factoryId
        }
        return carRepository.save(car)
    }

    fun update(carPut: CarPut): Car{
        val savedCar = carPut.id?.let { findByIdOrThrowBadRequestException(it) }
        val  factory = carPut.factoryId?.let { factoryService.findByIdOrThrowBadRequestException(it) }
        val car = CarMapper.INSTANCE.toPut(carPut)
        if (factory != null && savedCar != null) {
            car.id = savedCar.id
            car.factory = factory
        }
        return carRepository.save(car)
    }
    fun upload(file: MultipartFile): String{
        return try {
            val carList: MutableList<Car> = ArrayList()
            val inputStream = file.inputStream
            val settings = CsvParserSettings()
            settings.isHeaderExtractionEnabled = true
            val parser = CsvParser(settings)
            val parseAllRecords = parser.parseAllRecords(inputStream)
            parseAllRecords.forEach(Consumer { record: Record ->
                val factoryId =
                    factoryService.findByIdOrThrowBadRequestException(record.getString("MARCA_ID").toInt())
                val build = Car()
                        build.id = record.getString("ID").toInt()
                        build.factory = factoryId
                        build.model = record.getString("MODELO")
                        build.year = record.getString("ANO").toInt()
                        build.fuel = record.getString("COMBUSTIVEL")
                        build.doors = record.getString("NUM_PORTAS").toInt()
                        build.cost = record.getString("VALOR_FIPE").toDouble()
                        build.color = record.getString("COR")
                carList.add(build)
                carRepository.saveAll(carList)
            })
            "Upload SuccessFull !!!"
        } catch (e: IOException) {
            throw ValidationException("")
        }
    }

    fun delete(id: Int): Unit{
        return carRepository.delete(findByIdOrThrowBadRequestException(id))
    }


    fun findByIdOrThrowBadRequestException(id: Int): Car{
        return carRepository.findById(id)
            .orElseThrow { ValidationException("Car not Found") }
    }

    fun findAll():MutableList<Car>{
        return carRepository.findAll()
    }


    private fun validateCarInformed(request: CarPost){
        if (ObjectUtils.isEmpty(request.doors)){
            throw ValidationException("The Car Doors Was Not Informed")
        }

        if (ObjectUtils.isEmpty(request.color)){
            throw ValidationException("The Car Color Was Not Informed")
        }

        if (ObjectUtils.isEmpty(request.cost)){
            throw ValidationException("The Car Cost Was Not Informed")
        }

        if (ObjectUtils.isEmpty(request.year)){
            throw ValidationException("The Car Year Was Not Informed")
        }

        if (ObjectUtils.isEmpty(request.fuel)){
            throw ValidationException("The Car Fuel Was Not Informed")
        }

    }




}
