package weather.repository

import org.springframework.data.repository.CrudRepository
import weather.entity.WeatherEntity

interface WeatherRepository: CrudRepository<WeatherEntity, Int> {
    fun getByName(name: String): WeatherEntity?
}