package com.bookingDoctorSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("select a from Role as a where a.authority = ?1")
    Role findOneByAuthority(String authority);
}