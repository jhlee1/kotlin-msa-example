package lee.joohan.kotlinmsaexample.config

import lee.joohan.kotlinmsaexample.model.Customer
import lee.joohan.kotlinmsaexample.service.AdvanceService
import lee.joohan.kotlinmsaexample.service.ExampleService
import lee.joohan.kotlinmsaexample.service.ExampleServiceInterface
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Joohan Lee on 2020/03/31
 *
 */

@Configuration
class ApplicationConfig {

    @Bean
    @ConditionalOnExpression("#{'\${service.type}' == 'simple'}")
    fun exampleService(): ExampleServiceInterface = ExampleService()

    @Bean
    @ConditionalOnExpression("#{'\${service.type}' == 'advance'}")
    fun advanceService(): ExampleServiceInterface = AdvanceService()
}
