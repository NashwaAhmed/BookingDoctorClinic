package com.bookingDoctorSystem.model.validationModel;

import java.util.ArrayList;
import java.util.List;

public class EditWeekScheduleModel 
{
	    private long id;

	    private int bookingDuration;

	    private List<EditDayScheduleModel> editDayScheduleModels;

	    public EditWeekScheduleModel() {
	        this.setEditDayScheduleModels(new ArrayList<>());
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	   
	    public int getBookingDuration() {
			return bookingDuration;
		}

		public void setBookingDuration(int bookingDuration) {
			this.bookingDuration = bookingDuration;
		}

		public List<EditDayScheduleModel> getEditDayScheduleModels() {
	        return editDayScheduleModels;
	    }

	    public void setEditDayScheduleModels(List<EditDayScheduleModel> editDayScheduleModels) {
	        this.editDayScheduleModels = editDayScheduleModels;
	    }
}
