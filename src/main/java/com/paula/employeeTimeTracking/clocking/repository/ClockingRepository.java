package com.paula.employeeTimeTracking.clocking.repository;

import java.util.List;

import com.paula.employeeTimeTracking.clocking.entity.ClockingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paula.employeeTimeTracking.user.entity.UserEntity;

@Repository
public interface ClockingRepository extends JpaRepository<ClockingEntity, Long> {

	@Query("select c1 FROM ClockingEntity c1 WHERE c1.id = (SELECT MAX(c.id) from ClockingEntity c where c.user = :user)")
    ClockingEntity getLastClockingByUser(@Param("user") UserEntity user);
	
	
	@Query("select c from ClockingEntity c where c.user = :user ORDER BY c.id DESC")
    List<ClockingEntity> getClockingListByUserDesc(@Param("user") UserEntity user);
	
}
