package weather.model

data class Weather (
    val id: Int,
    val name: String,
    val main: Main
)

data class Main (
    val temp: Int
)
