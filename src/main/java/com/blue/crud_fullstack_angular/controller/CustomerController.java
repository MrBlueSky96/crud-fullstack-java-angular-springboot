package com.blue.crud_fullstack_angular.controller;

import com.blue.crud_fullstack_angular.entity.Customer;
import com.blue.crud_fullstack_angular.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://localhost:8080/api/customers
@RequestMapping("/api/customers")
//CrossOrigon es para evitar el error CORS del navegador
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8080/api/customers/create
    @PostMapping("/create")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    //http://localhost:8080/api/customers/get
    @GetMapping("/get")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    //http://localhost:8080/api/customers/get/id
    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    //http://localhost:8080/api/customers/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    //http://localhost:8080/api/customers/update
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer customerDatabase = customerService.findById(id);
        if(customerDatabase == null){
            return ResponseEntity.notFound().build();
        }
        customerDatabase.setFirstName(customer.getFirstName());
        customerDatabase.setLastName(customer.getLastName());
        customerDatabase.setEmail(customer.getEmail());

        Customer updated = customerService.update(customerDatabase);

        return ResponseEntity.ok(updated);
    }
}
