package lee.joohan.kotlinmsaexample.model

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Created by Joohan Lee on 2020/03/31
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}