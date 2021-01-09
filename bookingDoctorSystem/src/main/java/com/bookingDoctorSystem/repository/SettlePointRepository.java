package com.bookingDoctorSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.SettlePoint;

@Repository
public interface SettlePointRepository extends JpaRepository<SettlePoint, Long> {
	
	@Query("select a from SettlePoint as a ORDER BY a.name ASC")
    List<SettlePoint> findAllByOrderByName();
}
