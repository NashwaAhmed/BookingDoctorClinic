package com.bookingDoctorSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingDoctorSystem.repository.DoctorSpecialtyRepository;
import com.bookingDoctorSystem.service.DoctorSpecialtyService;

@Service
public class DoctorSpecialtyServiceImpl implements DoctorSpecialtyService {
    private DoctorSpecialtyRepository doctorSpecialtyRepository;

    @Autowired
    public DoctorSpecialtyServiceImpl(DoctorSpecialtyRepository doctorSpecialtyRepository) {
        this.doctorSpecialtyRepository = doctorSpecialtyRepository;
    }
}