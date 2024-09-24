package com.paula.employeeTimeTracking.clocking.dto;

import java.time.LocalDateTime;

import com.paula.employeeTimeTracking.clocking.entity.ClockingTypeEnum;
import com.paula.employeeTimeTracking.user.dto.UserDTO;


public record ClockingDTO(Long id, UserDTO user, LocalDateTime recordDateTime, ClockingTypeEnum type){}
