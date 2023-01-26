package weather.remote

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import weather.model.Weather

@Component
class WeatherRemoteImpl: WeatherRemote {
    override fun getWeather(cityName: String): Weather {
        val uri =
            "https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=01beaeaff35006a35f03b2073622e429&units=metric"
        val client = RestTemplate()
        return client.getForObject(uri, String)
    }
}