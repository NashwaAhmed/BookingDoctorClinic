package com.bookingDoctorSystem.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookingDoctorSystem.entity.Doctor;
import com.bookingDoctorSystem.entity.Patient;
import com.bookingDoctorSystem.entity.User;
import com.bookingDoctorSystem.exception.BookingNotFoundException;
import com.bookingDoctorSystem.exception.InvalidBookingDateException;
import com.bookingDoctorSystem.model.validationModel.AddBookingModel;
import com.bookingDoctorSystem.model.viewModel.BookingDateViewModel;
import com.bookingDoctorSystem.model.viewModel.BookingViewModel;
import com.bookingDoctorSystem.model.viewModel.DoctorSelectViewModel;
import com.bookingDoctorSystem.model.viewModel.PatientBasicViewModel;
import com.bookingDoctorSystem.service.BookingService;
import com.bookingDoctorSystem.service.DoctorService;
import com.bookingDoctorSystem.service.PatientService;

@Controller
@RequestMapping("/booking")
public class BookingController
{
    private BookingService bookingService;
    private DoctorService doctorService;
    private PatientService patientService;

    @Autowired
    public BookingController(BookingService bookingService,
                                 DoctorService doctorService, PatientService patientService) {
        this.bookingService = bookingService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }
    
    @GetMapping("/doctor/{bookingId}")
    public String getDoctorBooking(@PathVariable long bookingId, Authentication principal, Model model) {
        long userId = ((User) (principal).getPrincipal()).getId();
        Doctor doctor = this.doctorService.getByUserId(userId);
        BookingViewModel bookingViewModel = this.bookingService.getById(bookingId);

        // Is this booking to this doctor
        if (bookingViewModel.getDoctorSelectViewModel().getId() != doctor.getId()) {
            return "redirect:/booking/doctor";
        }

        model.addAttribute("bookingViewModel", bookingViewModel);

        return "booking/booking";
    }
    
    @GetMapping("/patient/{bookingId}")
    public String getPatientBooking(@PathVariable long bookingId, Authentication principal, Model model) {
        long userId = ((User) (principal).getPrincipal()).getId();
        Patient patient = this.patientService.getByUserId(userId);
        BookingViewModel bookingViewModel = this.bookingService.getById(bookingId);

        // Is this booking to this patient
        if (bookingViewModel.getPatientBasicViewModel().getId() != patient.getId()) {
            return "redirect:/booking/patient";
        }

        model.addAttribute("bookingViewModel", bookingViewModel);

        return "booking/booking";
    }
    
    @GetMapping("/patient/add")
    public String getPatientAddBooking(Principal principal, @RequestParam("date") @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm:ss a") Date date,
                                           @ModelAttribute AddBookingModel addBookingModel, Model model) {
        if (date.before(new Date())) {
            throw new InvalidBookingDateException();
        }

        addBookingModel.setDate(date);

        long userId = ((User) ((Authentication) principal).getPrincipal()).getId();
        Patient patient = this.patientService.getByUserId(userId);
        DoctorSelectViewModel doctorSelectViewModel = this.doctorService.getModelByUserId(patient.getDoctor().getUser().getId());
        model.addAttribute("doctorSelectViewModel", doctorSelectViewModel);


        return "booking/add";
    }
    
    @GetMapping("/doctor/add")
    public String getDoctorBooking(Principal principal,
                                          @RequestParam("date") @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm:ss a") Date date,
                                          @ModelAttribute AddBookingModel addBookingModel, Model model) {
        if (date.before(new Date())) {
            throw new InvalidBookingDateException();
        }

        addBookingModel.setDate(date);

        long userId = ((User) ((Authentication) principal).getPrincipal()).getId();
        DoctorSelectViewModel doctorSelectViewModel = this.doctorService.getModelByUserId(userId);
        model.addAttribute("doctorSelectViewModel", doctorSelectViewModel);

        List<PatientBasicViewModel> doctorPatients = this.patientService.getPatientsByDoctorId(doctorSelectViewModel.getId());
        model.addAttribute("doctorPatients", doctorPatients);

        return "booking/add";
    }
    
    @GetMapping("/getForDate")
    public ResponseEntity<List<BookingDateViewModel>> getWeekSchedule(
            @RequestParam("date") @DateTimeFormat(pattern = "MM/dd/yyyy") Date date, Authentication principal, HttpServletRequest request) {
        long doctorId = getDoctorId(principal, request);

        List<BookingDateViewModel> bookingDateViewModels = this.bookingService.getAllForDateAndDoctor(date, doctorId);

        return ResponseEntity.ok(bookingDateViewModels);
    }
    
    private long getDoctorId(Authentication principal, HttpServletRequest request) {
        if (principal != null) {
            long userId = ((User) principal.getPrincipal()).getId();
            if (request.isUserInRole("ROLE_DOCTOR")) {
                return this.doctorService.getByUserId(userId).getId();
            } else if (request.isUserInRole("ROLE_PATIENT")) {
                return this.patientService.getByUserId(userId).getDoctor().getId();
            }
        }

        return 0;
    }
    
    @ExceptionHandler(BookingNotFoundException.class)
    public String catchBookingNotFoundException() {
        return "error/booking-not-found";
    }

    @ExceptionHandler(InvalidBookingDateException .class)
    public String catchInvalidBooking() {
        return "error/invalid-booking-date";
    }
}
