package weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class WeatherApplication

fun main(args: Array<String>) {
	runApplication<WeatherApplication>(*args)
}