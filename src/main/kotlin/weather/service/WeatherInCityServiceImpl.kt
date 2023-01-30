package weather.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import weather.dto.MainInfoDto
import weather.dto.WeatherDto
import weather.entity.MainInfoEntity
import weather.entity.WeatherEntity
import weather.remote.WeatherRemote
import weather.repository.MainInfoRepository
import weather.repository.WeatherRepository

@Service
class WeatherInCityServiceImpl(
    private val weatherRepository: WeatherRepository,
    private val remote: WeatherRemote,
    private val mainInfoRepository: MainInfoRepository
) : WeatherInCityService {

    @Transactional
    override fun getWeather(cityName: String): WeatherDto {
        val response = remote.getWeather(cityName)
        var existingWeather = weatherRepository.getByName(cityName)
        if (existingWeather != null) {
            if (existingWeather.dt != response.dt) {
                existingWeather.dt = response.dt
                existingWeather = weatherRepository.save(existingWeather)
                mainInfoRepository.deleteByWeather(existingWeather)
                mainInfoRepository.save(response.main.toEntity(existingWeather))
                return existingWeather.toDto()
            } else {
                return existingWeather.toDto()
            }
        }
        val weatherEntity = weatherRepository.save(response.toEntity())
        mainInfoRepository.save(response.main.toEntity(weatherEntity))
        return response
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

    private fun WeatherDto.toEntity(): WeatherEntity =
        WeatherEntity(
            id = this.id,
            name = this.name,
            dt = this.dt
        )

    private fun MainInfoDto.toEntity(weatherEntity: WeatherEntity): MainInfoEntity =
        MainInfoEntity(
            id = 0,
            temp = this.temp,
            feels_like = this.feels_like,
            weather = weatherEntity
        )
}


