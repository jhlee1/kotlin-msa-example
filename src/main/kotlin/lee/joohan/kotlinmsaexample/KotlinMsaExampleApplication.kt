package lee.joohan.kotlinmsaexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class KotlinMsaExampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinMsaExampleApplication>(*args)

	@Controller
	class FirstController(val exampleService: ExampleService) {
		@GetMapping(value = ["/hello"])
		@ResponseBody
		fun hello(@PathVariable name : String) = exampleService.getHello(name);
	}
}
