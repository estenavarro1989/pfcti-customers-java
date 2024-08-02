package com.pfcti.customers.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;

@Data
@Entity
@NamedStoredProcedureQuery(name = "get_customers_order_by_birth_date_desc", procedureName = "get_customers_order_by_birth_date_desc", resultClasses = Customer.class, parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = Customer.class) })
public class Customer {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String phone;
    private LocalDate birth_date;
}
