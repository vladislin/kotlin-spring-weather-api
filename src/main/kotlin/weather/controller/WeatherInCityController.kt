package weather.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import weather.model.Weather
import weather.service.WeatherInCityServiceImpl

@RestController
class WeatherInCityController(val weatherInCityService: WeatherInCityServiceImpl) {
    @GetMapping("api/weather/{cityName}")
    fun getWeather(@PathVariable cityName: String): Weather? {
        return weatherInCityService.getWeather(cityName)
    }
}