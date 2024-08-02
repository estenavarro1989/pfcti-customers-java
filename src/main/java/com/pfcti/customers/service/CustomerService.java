package com.pfcti.customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfcti.customers.model.Customer;
import com.pfcti.customers.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer customer) {
        try {
            repository.addCustomer(customer.getId(), customer.getFirst_name(), customer.getLast_name(),
                    customer.getPhone(), customer.getBirth_date());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update(Customer customer) {
        try {
            repository.editCustomer(customer.getId(), customer.getFirst_name(), customer.getLast_name(),
                    customer.getPhone(), customer.getBirth_date());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(String id) {
        try {
            repository.deleteCustomer(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Customer> getCustomersOrderByBirthDate() {
        try {
            List<Customer> customers = repository.getCustomersOrderByBirthDate();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Customer> getCustomersOrderById() {
        try {
            List<Customer> customers = repository.getCustomersOrderById();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Customer> getCustomersOrderByName() {
        try {
            List<Customer> customers = repository.getCustomersOrderByName();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
