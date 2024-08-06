package com.pfcti.customers.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @NotBlank(message = "{api.error.customer.id.required}")
    @Size(max = 50, message = "{api.error.customer.id.length}")
    private String id;

    @NotBlank(message = "{api.error.customer.first.name.required}")
    @Size(max = 20, message = "{api.error.customer.first.name.max.length}")
    private String firstName;

    @NotBlank(message = "{api.error.customer.last.name.required}")
    @Size(max = 20, message = "{api.error.customer.last.name.max.length}")
    private String lastName;

    @Size(max = 20, message = "{api.error.customer.phone.max.length}")
    private String phone;

    @Past(message = "{api.error.customer.birth.date.past}")
    private LocalDate birthDate;
}
