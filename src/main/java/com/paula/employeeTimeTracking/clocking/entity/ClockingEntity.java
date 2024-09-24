package com.paula.employeeTimeTracking.clocking.entity;

import java.time.LocalDateTime;

import com.paula.employeeTimeTracking.clocking.dto.ClockingDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.paula.employeeTimeTracking.user.entity.UserEntity;

@Entity
public class ClockingEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
    @ManyToOne
	private UserEntity user;
	
	private LocalDateTime recordDateTime;

	@Enumerated(EnumType.STRING)
	private ClockingTypeEnum clockingType;

	public ClockingEntity(UserEntity user, LocalDateTime recordDateTime, ClockingTypeEnum clockingType) {
		this.user = user;
		this.recordDateTime = recordDateTime;
		this.clockingType = clockingType;
	}

	public ClockingEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public LocalDateTime getRecordDateTime() {
		return recordDateTime;
	}

	public void setRecordDateTime(LocalDateTime recordDateTime) {
		this.recordDateTime = recordDateTime;
	}

	public ClockingTypeEnum getClockingType() {
		return clockingType;
	}

	public void setClockingType(ClockingTypeEnum clockingType) {
		this.clockingType = clockingType;
	}

	public ClockingDTO getDTO() {
		ModelMapper  modelMapper = new ModelMapper();
		
		return modelMapper.map(this, ClockingDTO.class);
	}
}
