package com.bookingDoctorSystem.service;

import com.bookingDoctorSystem.model.validationModel.DayScheduleModel;
import com.bookingDoctorSystem.model.validationModel.EditDayScheduleModel;

public interface DayScheduleService {
	
	void create(DayScheduleModel dayScheduleModel);

    void save(EditDayScheduleModel editDayScheduleModel);
}
