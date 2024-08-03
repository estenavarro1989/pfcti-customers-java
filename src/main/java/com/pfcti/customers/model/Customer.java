package com.pfcti.customers.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDate;
}
