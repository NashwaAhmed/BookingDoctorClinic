package com.bookingDoctorSystem.service;

import com.bookingDoctorSystem.entity.WeekSchedule;
import com.bookingDoctorSystem.model.validationModel.EditWeekScheduleModel;

public interface WeekScheduleService {
	    EditWeekScheduleModel getById(long id);

	    WeekSchedule createDefault();

	    void save(EditWeekScheduleModel editWeekScheduleModel);

}
