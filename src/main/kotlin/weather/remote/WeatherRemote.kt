package weather.remote

import weather.model.Weather

interface WeatherRemote {
    fun getWeather(cityName: String) : Weather
}