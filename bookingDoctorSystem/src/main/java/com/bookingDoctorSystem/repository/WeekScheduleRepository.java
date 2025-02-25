package com.bookingDoctorSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.WeekSchedule;


@Repository
public interface WeekScheduleRepository extends JpaRepository<WeekSchedule, Long> {
}
