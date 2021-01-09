package com.bookingDoctorSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.DaySchedule;

@Repository
public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long>
{
	//use getone
}
