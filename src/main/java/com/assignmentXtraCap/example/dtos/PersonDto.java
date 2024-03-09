package com.assignmentXtraCap.example.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabets")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[5-9]\\d{9}$", message = "Invalid mobile number")
    private String mobileNumber;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Invalid email")
    private String email;

    @NotBlank(message = "Father's name is required")
    @Size(min = 3, message = "Father's name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Father's name must contain only alphabets")
    private String fathersName;

    @NotBlank(message = "Pan number is required")
    @Pattern(regexp = "^[A-Za-z]{3}[pP]{1}[A-Za-z]{1}[0-9]{4}[A-Za-z]{1}$", message = "Invalid PAN number")
    private String panNumber;

}
