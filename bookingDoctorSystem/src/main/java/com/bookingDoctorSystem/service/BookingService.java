package com.bookingDoctorSystem.service;

import java.util.Date;
import java.util.List;

import com.bookingDoctorSystem.model.validationModel.AddBookingModel;
import com.bookingDoctorSystem.model.viewModel.BookingDateViewModel;
import com.bookingDoctorSystem.model.viewModel.BookingViewModel;

public interface BookingService 
{
	void save(AddBookingModel addBookingModel);

	BookingViewModel getById(long id);
	
    List<BookingDateViewModel> getAllForDateAndDoctor(Date date, long doctorId);

    List<BookingDateViewModel> getAllByDate(Date date);

}
