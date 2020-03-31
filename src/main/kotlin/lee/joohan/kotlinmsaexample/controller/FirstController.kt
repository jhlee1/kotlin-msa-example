package lee.joohan.kotlinmsaexample.controller

import lee.joohan.kotlinmsaexample.service.AdvanceService
import lee.joohan.kotlinmsaexample.service.ExampleService
import lee.joohan.kotlinmsaexample.service.ExampleServiceInterface
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController(val exampleServiceInterface: ExampleServiceInterface) {
    @Value("\${service.message.text}")
    private lateinit var text : String

    @GetMapping(value = ["/hello/{name}"])
    @ResponseBody
    fun hello(@PathVariable name : String) = exampleServiceInterface.getHello(name);

    @GetMapping(value = ["/message"])
    @ResponseBody
    fun getMessage() = text;

}