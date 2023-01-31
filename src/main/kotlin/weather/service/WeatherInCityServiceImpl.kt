package weather.service

import org.springframework.stereotype.Service
import weather.dto.WeatherDto
import weather.entity.WeatherEntity
import weather.remote.WeatherRemote
import weather.repository.WeatherRepository
import java.time.LocalDate

@Service
class WeatherInCityServiceImpl(
    private val weatherRepository: WeatherRepository,
    private val remote: WeatherRemote,
) : WeatherInCityService {

    override fun getWeather(cityName: String): WeatherDto {
        val existingWeather = weatherRepository.getByNameAndDate(cityName, LocalDate.now())
        if (existingWeather == null) {
            val response = remote.getWeather(cityName)
            weatherRepository.save(response.toEntity())
            return response
        } else {
            println("From db")
            return existingWeather.toDto()
        }
    }

    private fun WeatherEntity.toDto(): WeatherDto =
        WeatherDto(
            name = this.name,
            date =  this.date,
            temp = this.temp
        )

    private fun WeatherDto.toEntity(): WeatherEntity =
        WeatherEntity(
            name = this.name,
            date = this.date,
            temp = this.temp
        )
}


