package com.bookingDoctorSystem.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingDoctorSystem.entity.Booking;
import com.bookingDoctorSystem.exception.BookingNotFoundException;
import com.bookingDoctorSystem.model.validationModel.AddBookingModel;
import com.bookingDoctorSystem.model.viewModel.BookingDateViewModel;
import com.bookingDoctorSystem.model.viewModel.BookingViewModel;
import com.bookingDoctorSystem.model.viewModel.DoctorSelectViewModel;
import com.bookingDoctorSystem.model.viewModel.PatientBasicViewModel;
import com.bookingDoctorSystem.repository.BookingRepository;
import com.bookingDoctorSystem.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService
{

	    private BookingRepository bookingRepository;
	    private ModelMapper modelMapper;
	    
	    
	    @Autowired
	    public BookingServiceImpl(BookingRepository bookingRepository, ModelMapper modelMapper)
	    {
	    	this.bookingRepository = bookingRepository;
	        this.modelMapper = modelMapper;
	    }
	    
	    
	    
	@Override
	public void save(AddBookingModel addBookingModel) {
		    Booking booking = this.modelMapper.map(addBookingModel, Booking.class);
	        this.bookingRepository.saveAndFlush(booking);	
	}
	   @Override
	    public BookingViewModel getById(long id) {
	        Booking booking = this.bookingRepository.findOne(id);
	        if (booking == null) {
	            throw new BookingNotFoundException();
	        }

	        return mapBookingViewModel(booking);
	    }

	@Override
	public List<BookingDateViewModel> getAllForDateAndDoctor(Date date, long doctorId) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date endDate = cal.getTime();

        List<Booking> bookings = this.bookingRepository.findAllBetweenDatesByDoctorId(date, endDate, doctorId);

        List<BookingDateViewModel> bookingDateViewModels = new ArrayList<>();

        for (Booking booking : bookings) {
        	BookingDateViewModel bookingDateViewModel = this.modelMapper.map(booking, BookingDateViewModel.class);
        	bookingDateViewModels.add(bookingDateViewModel);
        }
        return bookingDateViewModels;
	}


	@Override
	public  List<BookingDateViewModel> getAllByDate(Date date) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date endDate = cal.getTime();

        List<Booking> bookings = this.bookingRepository.findAllBetweenDates(date, endDate);

        List<BookingDateViewModel> bookingDateViewModels = new ArrayList<>();

        for (Booking booking : bookings) {
        	BookingDateViewModel bookingDateViewModel = this.modelMapper.map(booking, BookingDateViewModel.class);
        	bookingDateViewModels.add(bookingDateViewModel);
        }
        return bookingDateViewModels;
	}
	  private BookingViewModel mapBookingViewModel(Booking booking) {
		    BookingViewModel bookingViewModel = this.modelMapper.map(booking, BookingViewModel.class);
	        PatientBasicViewModel patientBasicViewModel = this.modelMapper.map(booking.getPatient(), PatientBasicViewModel.class);
	        bookingViewModel.setPatientBasicViewModel(patientBasicViewModel);
	        DoctorSelectViewModel doctorSelectViewModel = this.modelMapper.map(booking.getDoctor(), DoctorSelectViewModel.class);
	        bookingViewModel.setDoctorSelectViewModel(doctorSelectViewModel);

	        return bookingViewModel;
	    }

}
