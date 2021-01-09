package com.bookingDoctorSystem.service;

import java.util.List;

import com.bookingDoctorSystem.entity.Doctor;
import com.bookingDoctorSystem.model.validationModel.DoctorRegistrationModel;
import com.bookingDoctorSystem.model.validationModel.EditDoctorModel;
import com.bookingDoctorSystem.model.viewModel.DoctorSelectViewModel;
import com.bookingDoctorSystem.model.viewModel.DoctorViewModel;

public interface DoctorService 
{
	    void create(DoctorRegistrationModel registrationModel);

	    void save(EditDoctorModel editDoctorModel);

	    Doctor getById(long id);

	    DoctorViewModel getViewModelById(long id);

	    Doctor getByUserId(long userId);

	    EditDoctorModel getEditModelByUserId(long userId);

	    DoctorSelectViewModel getModelByUserId(long userId);

	    List<DoctorSelectViewModel> getAllSelect();

}
