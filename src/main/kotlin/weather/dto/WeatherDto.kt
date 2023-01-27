package weather.dto

data class WeatherDto(
    val id: Int,
    val name: String,
    val dt: Int,
    val main: MainInfoDto,
)