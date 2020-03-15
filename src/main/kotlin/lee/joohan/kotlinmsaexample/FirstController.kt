package lee.joohan.kotlinmsaexample

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController(val exampleService: ExampleService) {
    @GetMapping(value = ["/hello/{name}"])
    @ResponseBody
    fun hello(@PathVariable name : String) = exampleService.getHello(name);
}