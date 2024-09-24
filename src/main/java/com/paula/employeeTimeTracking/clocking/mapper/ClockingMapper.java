package com.paula.employeeTimeTracking.clocking.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.paula.employeeTimeTracking.clocking.dto.ClockingDTO;
import com.paula.employeeTimeTracking.clocking.entity.ClockingEntity;
import com.paula.employeeTimeTracking.user.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ClockingMapper {

	private final UserMapper userMapper;

	public ClockingMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

	public ClockingEntity toEntity(ClockingDTO clockingDTO){
		var user = userMapper.toEntity(clockingDTO.user());

		return new ClockingEntity(user, clockingDTO.recordDateTime(), clockingDTO.type());
	}

	public ClockingDTO toDTO(ClockingEntity clockingEntity){
		var userDTO = userMapper.toDTO(clockingEntity.getUser());

		return	new ClockingDTO(clockingEntity.getId(),userDTO, clockingEntity.getRecordDateTime(),clockingEntity.getClockingType());

	}
	
	public List<ClockingDTO> toDTOS(Collection<ClockingEntity> entities) {
	    return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<ClockingEntity> toEntities(Collection<ClockingDTO> dtos) {
	    return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	 }
}
