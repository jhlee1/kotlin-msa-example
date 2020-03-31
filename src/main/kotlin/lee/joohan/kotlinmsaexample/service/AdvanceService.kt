package lee.joohan.kotlinmsaexample.service

import org.springframework.beans.factory.annotation.Value

/**
 * Created by Joohan Lee on 2020/03/30
 *
 */


class AdvanceService : ExampleServiceInterface {
    @Value(value = "\${service.message.text}")
    private lateinit var text: String
    private var count = 1

    override fun getHello(name: String): String {
        count++
        return "$text $name ($count)"
    }
}