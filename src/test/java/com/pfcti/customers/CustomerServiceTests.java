package com.pfcti.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pfcti.customers.model.Customer;
import com.pfcti.customers.repository.CustomerRepository;
import com.pfcti.customers.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository repository;

    Customer mockCustomer = Customer.builder()
            .id("100")
            .firstName("John")
            .lastName("Doe")
            .phone("+50688888888")
            .birthDate(LocalDate.parse("1990-01-01"))
            .build();

    @Test
    public void testGetCustomersOrderById() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(mockCustomer);

        Mockito.when(repository.getCustomersOrderById()).thenReturn(mockCustomers);

        List<Customer> customers = repository.getCustomersOrderById();

        // Assert
        assertNotNull(customers);
        assertEquals("100", customers.get(0).getId());
        assertEquals("John", customers.get(0).getFirstName());
        assertEquals("Doe", customers.get(0).getLastName());
        assertEquals("+50688888888", customers.get(0).getPhone());
        assertEquals(LocalDate.parse("1990-01-01"), customers.get(0).getBirthDate());
    }

    @Test
    public void testGetCustomersOrderByBirthDate() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(mockCustomer);

        Mockito.when(repository.getCustomersOrderByBirthDate()).thenReturn(mockCustomers);

        List<Customer> customers = repository.getCustomersOrderByBirthDate();

        // Assert
        assertNotNull(customers);
        assertEquals("100", customers.get(0).getId());
        assertEquals("John", customers.get(0).getFirstName());
        assertEquals("Doe", customers.get(0).getLastName());
        assertEquals("+50688888888", customers.get(0).getPhone());
        assertEquals(LocalDate.parse("1990-01-01"), customers.get(0).getBirthDate());
    }

    @Test
    public void testGetCustomersOrderByName() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(mockCustomer);

        Mockito.when(repository.getCustomersOrderByName()).thenReturn(mockCustomers);

        List<Customer> customers = repository.getCustomersOrderByName();

        // Assert
        assertNotNull(customers);
        assertEquals("100", customers.get(0).getId());
        assertEquals("John", customers.get(0).getFirstName());
        assertEquals("Doe", customers.get(0).getLastName());
        assertEquals("+50688888888", customers.get(0).getPhone());
        assertEquals(LocalDate.parse("1990-01-01"), customers.get(0).getBirthDate());
    }
}
