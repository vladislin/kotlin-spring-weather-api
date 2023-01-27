package weather.repository

import org.springframework.data.repository.CrudRepository
import weather.entity.MainInfoEntity
import weather.entity.WeatherEntity

interface MainInfoRepository: CrudRepository<MainInfoEntity, Int> {

    fun deleteAllByWeather(weather: WeatherEntity)
}