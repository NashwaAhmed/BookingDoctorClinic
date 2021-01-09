package com.bookingDoctorSystem.service;

import java.util.List;

import com.bookingDoctorSystem.entity.Patient;
import com.bookingDoctorSystem.model.validationModel.EditPatientModel;
import com.bookingDoctorSystem.model.validationModel.PatientRegistrationModel;
import com.bookingDoctorSystem.model.viewModel.PatientBasicViewModel;
import com.bookingDoctorSystem.model.viewModel.PatientViewModel;

public interface PatientService
{
	void create(PatientRegistrationModel registrationModel);

    void save(EditPatientModel editPatientModel);

    PatientViewModel getById(long id);

    Patient getByUserId(long userId);

    EditPatientModel getEditModelByUserId(long userId);

    PatientBasicViewModel getBasicById(long id);

    List<PatientBasicViewModel> getPatientsByDoctorId(long doctorId);
    
}
