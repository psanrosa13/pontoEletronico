package com.paula.employeeTimeTracking.clocking.dto;

import java.util.List;

public record TrackingDTO(Long amount, List<ClockingDTO> records) {}
