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
    @NotBlank(message = "El id del cliente es requerido")
    @Size(max = 50, message = "El máximo de caracteres del id es de 50")
    private String id;

    @NotBlank(message = "El nombre del cliente es requerido")
    @Size(max = 20, message = "El máximo de caracteres del nombre es de 20")
    private String firstName;

    @NotBlank(message = "El apellido del cliente es requerido")
    @Size(max = 20, message = "El máximo de caracteres del apellido es de 20")
    private String lastName;

    //@Size(max = 20, message = "El máximo de caracteres del teléfono es de 20") //org.postgresql.util.PSQLException
    private String phone;

    @Past(message = "La fecha de nacimiento tiene que ser anterior al día de hoy")
    private LocalDate birthDate;
}
