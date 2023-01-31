package weather.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import weather.dto.WeatherDto
import weather.service.WeatherInCityService

@RestController
class WeatherInCityController(val weatherInCityService: WeatherInCityService) {
    @GetMapping("api/weather/{cityName}")
    fun getWeather(@PathVariable cityName: String): WeatherDto = weatherInCityService.getWeather(cityName)
}