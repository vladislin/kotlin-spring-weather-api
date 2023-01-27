package weather.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
class WeatherEntity(
    @Id
    val id: Int = 0,
    var name: String = "",
    var dt: Int = 0,
    @OneToOne(mappedBy = "weather", cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    @JsonManagedReference
    val main_info: MainInfoEntity? = null
)

