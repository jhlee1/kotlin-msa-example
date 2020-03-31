package lee.joohan.kotlinmsaexample;

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


/**
 * Created by Joohan Lee on 2020/03/30
 */
@Component
class SpELExample {
    @Value(value = "#{4+3}")
    private lateinit var result1 : Number

    @Value(value = "#{ \${one.value} div \${another.value} }")
    private lateinit var result2 : Number

    @Value(value = "#{ \${one.bool} eq \${another.bool} }")
    private lateinit var result3 : Comparable<Boolean>

    @Value(value = "#{ \${one.bool} and \${another.bool} }")
    private lateinit var result4 : Comparable<Boolean>

    @Value(value = "\${service.message.simple:hello}")
    private lateinit var result5 : String

    @Value(value = "#{ '\${some.value}' matches '[a-zA-Z\\s]+' }")
    private lateinit var result6 : Comparable<Boolean>

}
