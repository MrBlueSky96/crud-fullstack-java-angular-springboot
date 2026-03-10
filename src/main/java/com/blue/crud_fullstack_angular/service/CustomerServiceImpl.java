package com.blue.crud_fullstack_angular.service;

import com.blue.crud_fullstack_angular.entity.Customer;
import com.blue.crud_fullstack_angular.exception.ResourceNotFoundException;
import com.blue.crud_fullstack_angular.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente con id " + id + " no se encuentra");
        });
        //return customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public void deleteById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cliente con id " + id + " no se encuentra para eliminar"));
        customerRepository.deleteById(customer.getId());
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

}
