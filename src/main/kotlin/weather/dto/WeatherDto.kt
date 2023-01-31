package weather.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherDto(
    val name: String,
    val date: LocalDate = LocalDate.now(),
    var temp: Int,
) {
    @JsonProperty("main")
    private fun unpackTemp(main: Map<String, Int>) {
        temp = main["temp"]!!
    }
}



