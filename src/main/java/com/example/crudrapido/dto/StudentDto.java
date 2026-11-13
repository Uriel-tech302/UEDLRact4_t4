package com.example.crudrapido.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDto {
    
    @NotBlank(message = "El nombre es obligatorio.")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio.")
    private String lastName;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El formato del correo no es válido.")
    private String email;
}