package com.bookingDoctorSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select a from User as a where a.username = ?1")
    User findOneByUsername(String username);
}