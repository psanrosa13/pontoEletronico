package com.paula.employeeTimeTracking.clocking.controller;

import com.paula.employeeTimeTracking.clocking.mapper.ClockingMapper;
import com.paula.employeeTimeTracking.clocking.dto.ClockingDTO;
import com.paula.employeeTimeTracking.clocking.dto.TrackingDTO;
import com.paula.employeeTimeTracking.clocking.entity.ClockingEntity;
import com.paula.employeeTimeTracking.clocking.service.ClockingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clocks")
public class ClockingController {

	private final ClockingService clockingService;

	private final ClockingMapper clockingMapper;

	public ClockingController(ClockingService clockingService, ClockingMapper clockingMapper) {
		this.clockingService = clockingService;
		this.clockingMapper = clockingMapper;
	}

	@PostMapping
	public ClockingDTO insertNewClocking(@RequestBody ClockingDTO ponto) {
		ClockingEntity clockingEntity =
				clockingService.insertNewClocking(clockingMapper.toEntity(ponto));
		
		return clockingMapper.toDTO(clockingEntity);
	}
	
	@GetMapping("/user/{id}")
	public TrackingDTO getTrackingByUserId(@PathVariable Long id) {
		return clockingService.getRecordsByUserId(id);
	}
	
}
