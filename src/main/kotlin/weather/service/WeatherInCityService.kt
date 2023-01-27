package weather.service

import weather.dto.WeatherDto

interface WeatherInCityService {
    fun getWeather(cityName: String): WeatherDto
}