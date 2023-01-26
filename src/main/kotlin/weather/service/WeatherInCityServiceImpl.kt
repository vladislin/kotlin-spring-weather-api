package weather.service

import org.springframework.stereotype.Service
import weather.model.Weather
import weather.remote.WeatherRemoteImpl

@Service
class WeatherInCityServiceImpl(val remote: WeatherRemoteImpl) : WeatherInCityService {
    override fun getWeather(cityName: String): Weather {
        return remote.getWeather(cityName)
    }
}