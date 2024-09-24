package com.paula.employeeTimeTracking.user.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.paula.employeeTimeTracking.user.dto.UserDTO;
import com.paula.employeeTimeTracking.user.entity.UserEntity;

@Component
public class UserMapper {

	public UserEntity toEntity(UserDTO userDTO){
		return new UserEntity(userDTO.fullName(),userDTO.cpf(), userDTO.email(), userDTO.recordDate());
	}

	public UserDTO toDTO(UserEntity userEntity){
		return new UserDTO(userEntity.getId(), userEntity.getFullName(), userEntity.getCpf(), userEntity.getEmail(), userEntity.getRecordDate());
	}
	
	public List<UserDTO> toDTOs(Collection<UserEntity> entities) {
	    return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<UserEntity> toEntities(Collection<UserDTO> dtos) {
	    return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	 }
}
