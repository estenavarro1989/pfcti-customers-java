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
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable String id, @RequestBody Customer newCustomer) throws Exception {
        Customer oldCustomer = getCustomerById(id);

        Customer res = service.update(id, newCustomer, oldCustomer);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) throws Exception {
        return service.getCustomerById(id);
    }


    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomersOrderByBirthDate(@RequestParam("orderBy") String orderBy) {
        if(orderBy.equals("birthDate")) {
            return new ResponseEntity<>(service.getCustomersOrderByBirthDate(), HttpStatus.OK);
        } else if (orderBy.equals("id")) {
            return new ResponseEntity<>(service.getCustomersOrderById(), HttpStatus.OK);
        } else if (orderBy.equals("name")) {
            return new ResponseEntity<>(service.getCustomersOrderByName(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);        
        }
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