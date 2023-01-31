package weather.entity

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(WeatherId::class)
class WeatherEntity(
    @Id var name: String = "",
    @Id var date: LocalDate = LocalDate.now(),
    val temp: Int = 0
)

class WeatherId(
    val name: String = "",
    val date: LocalDate = LocalDate.now(),
): Serializable

