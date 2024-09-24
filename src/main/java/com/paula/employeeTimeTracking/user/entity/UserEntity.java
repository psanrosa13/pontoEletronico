package com.paula.employeeTimeTracking.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String fullName;

	private String cpf;

	private String email;
	
	private LocalDate recordDate;

	public UserEntity(String fullName, String cpf, String email, LocalDate recordDate) {
		this.fullName = fullName;
		this.cpf = cpf;
		this.email = email;
		this.recordDate = recordDate;
	}

	public UserEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDate recordData) {
		this.recordDate = recordData;
	}
}
