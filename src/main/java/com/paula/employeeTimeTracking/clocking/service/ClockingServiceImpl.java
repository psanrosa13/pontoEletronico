package com.paula.employeeTimeTracking.clocking.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.paula.employeeTimeTracking.clocking.mapper.ClockingMapper;
import com.paula.employeeTimeTracking.clocking.dto.TrackingDTO;
import com.paula.employeeTimeTracking.clocking.entity.ClockingEntity;
import com.paula.employeeTimeTracking.clocking.entity.ClockingTypeEnum;
import com.paula.employeeTimeTracking.clocking.exception.UltimoPontoDoMesmoTipoException;
import com.paula.employeeTimeTracking.clocking.repository.ClockingRepository;
import org.springframework.stereotype.Service;

import com.paula.employeeTimeTracking.user.entity.UserEntity;

@Service
public class ClockingServiceImpl implements ClockingService {

	private final ClockingRepository clockingRepository;

	private final ClockingMapper clockingMapper;

	public ClockingServiceImpl(ClockingRepository clockingRepository, ClockingMapper clockingMapper) {
		this.clockingRepository = clockingRepository;
		this.clockingMapper = clockingMapper;
	}

	public ClockingEntity insertNewClocking(ClockingEntity clocking) {
		clocking.setRecordDateTime(LocalDateTime.now());
		
		ClockingEntity lastClocking = clockingRepository.getLastClockingByUser(clocking.getUser());
		
		if(lastClocking != null && lastClocking.getClockingType().equals(clocking.getClockingType())) {
			throw new UltimoPontoDoMesmoTipoException();
		}
		
		return clockingRepository.save(clocking);
	}
	
	public TrackingDTO getRecordsByUserId(Long userId) {

		var user = new UserEntity();
		user.setId(userId);
		
		List<ClockingEntity> records= clockingRepository.getClockingListByUserDesc(user);
		
		return new TrackingDTO(getAmountWorkHours(records), clockingMapper.toDTOS(records));
	}

	private Long getAmountWorkHours(List<ClockingEntity> registros) {
		long amount = 0;
		LocalDateTime localDateTimeEnd ;
		
		for (ClockingEntity registro : registros) {

			if(registro.getClockingType() == ClockingTypeEnum.END) {
				localDateTimeEnd = registro.getRecordDateTime();
			}else {
				localDateTimeEnd = LocalDateTime.now();
			}

			amount=+ Duration.between(registro.getRecordDateTime(), localDateTimeEnd).toMinutes();
		}
		
		if(amount != 0 ) {
			return amount/60;
		}

		return amount;
	}
}
