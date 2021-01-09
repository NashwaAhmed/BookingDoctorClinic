package com.bookingDoctorSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookingDoctorSystem.entity.User;
import com.bookingDoctorSystem.model.validationModel.EditPatientModel;
import com.bookingDoctorSystem.model.validationModel.PatientRegistrationModel;
import com.bookingDoctorSystem.model.viewModel.DoctorSelectViewModel;
import com.bookingDoctorSystem.model.viewModel.PatientViewModel;
import com.bookingDoctorSystem.service.DoctorService;
import com.bookingDoctorSystem.service.PatientService;

@RequestMapping("/patient")
public class PatientController 
{
	    private PatientService patientService;

	    private DoctorService doctorService;

	    @Autowired
	    public PatientController(PatientService patientService, DoctorService doctorService) {
	        this.patientService = patientService;
	        this.doctorService = doctorService;
	    }
	    
	    @GetMapping("/patient/{id}")
	    public String getPatient(@PathVariable long id, Model model) {
	        PatientViewModel patientViewModel = this.patientService.getById(id);

	        model.addAttribute("patientViewModel", patientViewModel);

	        return "patient/patient";
	    }
	    @GetMapping("/register-patient")
	    public String getPatientRegister(@ModelAttribute PatientRegistrationModel patientRegistrationModel, Model model) {
	        List<DoctorSelectViewModel> doctors = this.doctorService.getAllSelect();
	        model.addAttribute("doctors", doctors);

	        return "patient/register";
	    }
	    
	    @GetMapping("/patient/edit")
	    public String getEditPatient(Model model, Authentication principal) {
	        long userId = ((User) principal.getPrincipal()).getId();

	        EditPatientModel editPatientModel = this.patientService.getEditModelByUserId(userId);

	        model.addAttribute("editPatientModel", editPatientModel);

	        return "patient/edit";
	    }


}
