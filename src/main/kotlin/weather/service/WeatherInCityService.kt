package weather.service

import weather.model.Weather

interface WeatherInCityService {
    fun getWeather(cityName: String): Weather
}