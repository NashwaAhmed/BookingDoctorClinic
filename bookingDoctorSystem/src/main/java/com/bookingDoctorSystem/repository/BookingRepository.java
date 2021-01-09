package com.bookingDoctorSystem.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> 
{
	 @Query("select a from Booking as a where a.date between ?1 and ?2 and a.doctor.id = ?3")
	 List<Booking> findAllBetweenDatesByDoctorId(Date startDate, Date endDate, long doctorId);
	 
	 @Query("select a from Booking as a where a.date between ?1 and ?2")
	 List<Booking> findAllBetweenDates(Date startDate, Date endDate);
}
