package weather.remote

import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import weather.dto.MainInfoDto
import weather.dto.WeatherDto
import weather.entity.MainInfoEntity
import weather.entity.WeatherEntity
import weather.repository.MainInfoRepository
import weather.repository.WeatherRepository


@Component
class WeatherRemoteImpl(
    private val weatherRepository: WeatherRepository,
    private val mainInfoRepository: MainInfoRepository
) : WeatherRemote {
    override fun getWeather(cityName: String): WeatherDto {
        val uri =
            "https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=01beaeaff35006a35f03b2073622e429&units=metric"
        val client = RestTemplate()
        val response = client.getForObject<WeatherDto>(uri)
        val weatherEntity = weatherRepository.save(response.toEntity())
        mainInfoRepository.save(response.main.toEntity(weatherEntity))

        return response
    }


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