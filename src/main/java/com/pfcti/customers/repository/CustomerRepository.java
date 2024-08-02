package com.pfcti.customers.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfcti.customers.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Procedure(value = "create_customer")
    void addCustomer(
            @Param("p_id") String id,
            @Param("p_first_name") String firstName,
            @Param("p_last_name") String lastName,
            @Param("p_phone") String phone,
            @Param("p_birth_date") LocalDate birthDate);

    @Procedure(value = "update_customer")
    void editCustomer(
            @Param("p_id") String id,
            @Param("p_first_name") String firstName,
            @Param("p_last_name") String lastName,
            @Param("p_phone") String phone,
            @Param("p_birth_date") LocalDate birthDate);

    @Procedure(value = "delete_customer")
    void deleteCustomer(@Param("p_id") String id);

    @Procedure(value = "get_customers_order_by_birth_date_desc", outputParameterName = "p_result", refCursor = true)
    List<Customer> getCustomersOrderByBirthDate();

    @Procedure(value = "get_customers_order_by_id", outputParameterName = "p_result", refCursor = true)
    List<Customer> getCustomersOrderById();

    @Procedure(value = "get_customers_order_by_name", outputParameterName = "p_result", refCursor = true)
    List<Customer> getCustomersOrderByName();
}