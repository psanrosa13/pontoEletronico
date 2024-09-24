package com.paula.employeeTimeTracking.user.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paula.employeeTimeTracking.user.mapper.UserMapper;
import com.paula.employeeTimeTracking.user.dto.UserDTO;
import com.paula.employeeTimeTracking.user.entity.UserEntity;
import com.paula.employeeTimeTracking.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	UserService userService;

	UserMapper userMapper;

	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UserDTO insertNewUser(@Valid @RequestBody UserDTO userDTO) {
		UserEntity userEntity =
				userService.insertNewUser(userMapper.toEntity(userDTO));
		
		return userMapper.toDTO(userEntity);
	}
	
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Long id) {
		return userMapper.toDTO(userService.findById(id));
	}
	
	@PutMapping("/{id}")
	public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		UserEntity userEntity =
				userService.update(userMapper.toEntity(userDTO), id);
		
		return userMapper.toDTO(userEntity);
	}
	
	@GetMapping
	public List<UserDTO> getAll(){
		return userMapper.toDTOs(userService.getAll());
	}

}
