package com.pfcti.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
        service.update(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
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