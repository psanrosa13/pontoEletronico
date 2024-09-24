package com.paula.employeeTimeTracking.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
