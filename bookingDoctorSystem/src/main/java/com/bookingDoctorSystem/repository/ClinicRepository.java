package com.bookingDoctorSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingDoctorSystem.entity.Clinic;


@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long>
{

}
