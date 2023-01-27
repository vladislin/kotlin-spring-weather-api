package weather.service

import org.springframework.stereotype.Service
import weather.dto.MainInfoDto
import weather.dto.WeatherDto
import weather.entity.MainInfoEntity
import weather.entity.WeatherEntity
import weather.remote.WeatherRemote
import weather.repository.WeatherRepository

@Service
class WeatherInCityServiceImpl(
    private val weatherRepository: WeatherRepository,
    private val remote: WeatherRemote
) : WeatherInCityService {

    override fun getWeather(cityName: String): WeatherDto {
        return weatherRepository.getByName(cityName)
            ?.toDto()
            ?: remote.getWeather(cityName)
    }

    private fun WeatherEntity.toDto(): WeatherDto =
        WeatherDto(
            id = this.id,
            name = this.name,
            dt = this.dt,
            main = this.main_info!!.toDto()
        )

    private fun MainInfoEntity.toDto(): MainInfoDto =
        MainInfoDto(
            temp = this.temp,
            feels_like = this.feels_like
        )
}


