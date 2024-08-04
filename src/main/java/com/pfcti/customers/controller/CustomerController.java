package com.pfcti.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfcti.customers.model.Customer;
import com.pfcti.customers.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        service.save(customer);
    }

    @PutMapping
    public void editCustomer(@RequestBody Customer customer) {
        service.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/birthDate")
    public List<Customer> getCustomersOrderByBirthDate() {
        return service.getCustomersOrderByBirthDate();
    }

    @GetMapping("/id")
    public List<Customer> getCustomersOrderById() {
        return service.getCustomersOrderById();
    }

    @GetMapping("/name")
    public List<Customer> getCustomersOrderByName() {
        return service.getCustomersOrderByName();
    }
}