package com.bookingDoctorSystem.serviceImpl;

import java.sql.Time;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingDoctorSystem.entity.DayOfWeek;
import com.bookingDoctorSystem.entity.DaySchedule;
import com.bookingDoctorSystem.entity.WeekSchedule;
import com.bookingDoctorSystem.model.validationModel.DayScheduleModel;
import com.bookingDoctorSystem.model.validationModel.EditDayScheduleModel;
import com.bookingDoctorSystem.model.validationModel.EditWeekScheduleModel;
import com.bookingDoctorSystem.repository.WeekScheduleRepository;
import com.bookingDoctorSystem.service.DayScheduleService;
import com.bookingDoctorSystem.service.WeekScheduleService;

@Service
public class WeekScheduleServiceImpl implements WeekScheduleService {
    private WeekScheduleRepository weekScheduleRepository;

    private ModelMapper modelMapper;

    private DayScheduleService dayScheduleService;

    @Autowired
    public WeekScheduleServiceImpl(WeekScheduleRepository weekScheduleRepository, ModelMapper modelMapper,
                                   DayScheduleService dayScheduleService) {
        this.weekScheduleRepository = weekScheduleRepository;
        this.modelMapper = modelMapper;
        this.dayScheduleService = dayScheduleService;
    }

	@Override
	public EditWeekScheduleModel getById(long id) {
		WeekSchedule weekSchedule = this.weekScheduleRepository.findOne(id);

        EditWeekScheduleModel editWeekScheduleModel = this.modelMapper.map(weekSchedule, EditWeekScheduleModel.class);
        for (DaySchedule daySchedule : weekSchedule.getDaySchedules()) {
            EditDayScheduleModel editDayScheduleModel = this.modelMapper.map(daySchedule, EditDayScheduleModel.class);
            editDayScheduleModel.setStartTimeStr(daySchedule.getStartTime().toString());
            editDayScheduleModel.setEndTimeStr(daySchedule.getEndTime().toString());
            editWeekScheduleModel.getEditDayScheduleModels().add(editDayScheduleModel);
        }

        return editWeekScheduleModel;
	}

	@Override
	public WeekSchedule createDefault() {
		 WeekSchedule weekSchedule = this.weekScheduleRepository.saveAndFlush(new WeekSchedule());

	        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
	            DayScheduleModel dayScheduleModel = new DayScheduleModel();
	            dayScheduleModel.setDayOfWeek(dayOfWeek.toString());
	            dayScheduleModel.setStartTime(Time.valueOf("00:00:00"));
	            dayScheduleModel.setEndTime(Time.valueOf("00:00:00"));
	            dayScheduleModel.setWeekSchedule(weekSchedule);

	            this.dayScheduleService.create(dayScheduleModel);
	        }

	        return weekSchedule;
	}

	@Override
	public void save(EditWeekScheduleModel editWeekScheduleModel) {
		WeekSchedule weekSchedule = this.weekScheduleRepository.getOne(editWeekScheduleModel.getId());
        weekSchedule.setBookingDuration(editWeekScheduleModel.getBookingDuration());
        this.weekScheduleRepository.saveAndFlush(weekSchedule);

        for (EditDayScheduleModel editDayScheduleModel : editWeekScheduleModel.getEditDayScheduleModels()) {
            this.dayScheduleService.save(editDayScheduleModel);
        }
    }
		
	}

