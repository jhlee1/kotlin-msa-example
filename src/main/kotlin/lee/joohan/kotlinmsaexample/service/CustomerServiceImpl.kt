package lee.joohan.kotlinmsaexample.service

import lee.joohan.kotlinmsaexample.model.Customer
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Joohan Lee on 2020/03/31
 *
 */

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring", Customer.Telephone("+44", "7123456789")),
                Customer(3, "Microservice", Customer.Telephone("+44", "7123456789"))
        )
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer;
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id);
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id);
        createCustomer(customer);
    }

    override fun searchCustomer(nameFilter: String): List<Customer> {
        return customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList();
    }

}