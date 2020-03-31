package lee.joohan.kotlinmsaexample.service

import org.springframework.stereotype.Service

class ExampleService : ExampleServiceInterface {
    override fun getHello(name :String) = "Hello $name"
}