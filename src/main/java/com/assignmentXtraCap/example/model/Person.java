package com.assignmentXtraCap.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabets")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "[56789]\\d{9}", message = "Invalid mobile number")
    private String mobileNumber;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Father's name is required")
    @Size(min = 3, message = "Father's name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Father's name must contain only alphabets")
    private String fathersName;

    @Pattern(regexp = "[A-Za-z]{3}[pP]{1}[A-Za-z]{1}[0-9]{4}[A-Za-z]{1}", message = "Invalid PAN number")
    private String panNumber;


}