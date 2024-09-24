package com.paula.employeeTimeTracking.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserDTO(Long id, @NotNull @NotBlank String fullName, @NotNull @NotBlank @CPF String cpf, @NotNull @NotBlank @Email String email, LocalDate recordDate){
	
}
