package com.paula.employeeTimeTracking.user.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paula.employeeTimeTracking.user.entity.UserEntity;
import com.paula.employeeTimeTracking.user.exception.UsuarioInexistenteException;
import com.paula.employeeTimeTracking.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserEntity insertNewUser(UserEntity user) {
		user.setRecordDate(LocalDate.now());
		
		return userRepository.save(user);
	}
	
	public UserEntity update(UserEntity user, Long id) {
		Optional<UserEntity> userRecord = userRepository.findById(id);
		
		if(userRecord.isEmpty()) {
			throw new UsuarioInexistenteException();
		}
		
		userRecord.get().setCpf(user.getCpf());
		userRecord.get().setEmail(user.getEmail());
		userRecord.get().setFullName(user.getFullName());

		return userRepository.save(userRecord.get());
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UsuarioInexistenteException();
		}
	
		return user.get();
	}

	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}
}
