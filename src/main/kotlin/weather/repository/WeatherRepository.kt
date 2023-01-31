package weather.repository

import org.springframework.data.repository.CrudRepository
import weather.entity.WeatherEntity
import weather.entity.WeatherId
import java.time.LocalDate

interface WeatherRepository: CrudRepository<WeatherEntity, WeatherId> {
    fun getByNameAndDate(name: String, date: LocalDate): WeatherEntity?
}