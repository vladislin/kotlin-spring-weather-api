package weather.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
class MainInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val temp: Int = 0,
    val feels_like: Int =0,
    @OneToOne()
    @JoinColumn(name = "weather_id")
    @JsonManagedReference
    var weather: WeatherEntity = WeatherEntity(),
)