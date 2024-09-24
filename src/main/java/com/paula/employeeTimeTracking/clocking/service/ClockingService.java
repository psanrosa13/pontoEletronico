package com.paula.employeeTimeTracking.clocking.service;

import com.paula.employeeTimeTracking.clocking.dto.TrackingDTO;
import com.paula.employeeTimeTracking.clocking.entity.ClockingEntity;


public interface ClockingService {

	ClockingEntity insertNewClocking(ClockingEntity ponto);
	
	TrackingDTO getRecordsByUserId(Long userId);
	
}
