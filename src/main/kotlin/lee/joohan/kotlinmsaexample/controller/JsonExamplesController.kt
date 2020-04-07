package lee.joohan.kotlinmsaexample.controller

import lee.joohan.kotlinmsaexample.model.ComplexObject
import lee.joohan.kotlinmsaexample.model.SimpleObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonExamplesController {
    @GetMapping("/json")
    fun getJson() = ComplexObject(obj = SimpleObject("more", "complex"));
}