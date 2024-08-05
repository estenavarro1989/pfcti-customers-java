package com.pfcti.customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfcti.customers.model.Customer;
import com.pfcti.customers.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer customer) {
        try {
            repository.addCustomer(customer.getId(), customer.getFirstName(), customer.getLastName(),
                    customer.getPhone(), customer.getBirthDate());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Customer update(String id, Customer newCustomer, Customer oldCustomer) {
        try {
            newCustomer.setId(id);
            newCustomer.setFirstName(newCustomer.getFirstName() != null ? newCustomer.getFirstName() : oldCustomer.getFirstName());
            newCustomer.setLastName(newCustomer.getLastName() != null ? newCustomer.getLastName() : oldCustomer.getLastName());
            newCustomer.setPhone(newCustomer.getPhone() != null ? newCustomer.getPhone() : oldCustomer.getPhone());
            newCustomer.setBirthDate(newCustomer.getBirthDate() != null ? newCustomer.getBirthDate() : oldCustomer.getBirthDate());

            repository.editCustomer(id, newCustomer.getFirstName(), newCustomer.getLastName(),
                    newCustomer.getPhone(), newCustomer.getBirthDate());

            return newCustomer;
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

    @Transactional
    public Customer getCustomerById(String id) {
        try {
            List<Customer> customer = repository.getCustomerById(id);
            return customer.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public List<Customer> getCustomersOrderByBirthDate() {
        try {
            List<Customer> customers = repository.getCustomersOrderByBirthDate();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public List<Customer> getCustomersOrderById() {
        try {
            List<Customer> customers = repository.getCustomersOrderById();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
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
