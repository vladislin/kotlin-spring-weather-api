package weather.remote

import weather.dto.WeatherDto

interface WeatherRemote {
    fun getWeather(cityName: String) : WeatherDto
}