package lee.joohan.kotlinmsaexample.service

import lee.joohan.kotlinmsaexample.model.Customer

/**
 * Created by Joohan Lee on 2020/03/31
 *
 */
interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun createCustomer(customer: Customer)
    fun deleteCustomer(id: Int)
    fun updateCustomer(id: Int, customer: Customer)
    fun searchCustomer(nameFilter: String): List<Customer>
}