package com.bookingDoctorSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("select a from Doctor as a where a.user.id = ?1")
    Doctor findOneByUserId(long userId);

	@Query("select a from Doctor as a ORDER BY a.firstName ASC")
    List<Doctor> findAllByOrderByFirstName();
}
