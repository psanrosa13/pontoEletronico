package com.paula.employeeTimeTracking.templates;

import java.time.LocalDateTime;
import java.time.Month;

import com.paula.employeeTimeTracking.clocking.dto.ClockingDTO;
import com.paula.employeeTimeTracking.clocking.entity.ClockingTypeEnum;

public class ClockingTemplate {

	public static ClockingDTO getPontoEntradaSegunda(){
		return new ClockingDTO(null, UserTemplate.getUsuarioPontoUm(), LocalDateTime.of(2020, Month.APRIL, 13, 12, 30), ClockingTypeEnum.BEGIN);
	}

	public static ClockingDTO getPontoSaidaSegunda(){
		return new ClockingDTO(null, UserTemplate.getUsuarioPontoUm(), LocalDateTime.of(2020, Month.APRIL, 13, 18, 20), ClockingTypeEnum.END);
	}

}
