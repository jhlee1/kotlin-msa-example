package lee.joohan.kotlinmsaexample.controller

import lee.joohan.kotlinmsaexample.model.Customer
import lee.joohan.kotlinmsaexample.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by Joohan Lee on 2020/03/31
 *
 */
@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) = customerService.searchCustomer(nameFilter)

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id : Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id)
        val status = if (customer == null) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(customer, status)
    }

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer: Customer) : ResponseEntity<Unit> {
        customerService.createCustomer(customer)

        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(@RequestBody customer: Customer) = customerService.createCustomer(customer)

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int) = customerService.deleteCustomer(id)
}