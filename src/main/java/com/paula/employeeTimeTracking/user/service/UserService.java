package com.paula.employeeTimeTracking.user.service;

import java.util.List;

import com.paula.employeeTimeTracking.user.entity.UserEntity;

public interface UserService {

	UserEntity insertNewUser(UserEntity user);
	
	UserEntity update(UserEntity user, Long id);
	
	UserEntity findById(Long id);
	
	List<UserEntity> getAll();
}
