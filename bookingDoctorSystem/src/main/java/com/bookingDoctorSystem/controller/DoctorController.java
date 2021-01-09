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
import com.bookingDoctorSystem.model.validationModel.DoctorRegistrationModel;
import com.bookingDoctorSystem.model.validationModel.EditDoctorModel;
import com.bookingDoctorSystem.model.viewModel.DoctorViewModel;
import com.bookingDoctorSystem.model.viewModel.SettlePointViewModel;
import com.bookingDoctorSystem.service.DoctorService;
import com.bookingDoctorSystem.service.SettlePointService;

@RequestMapping("/doctor")
public class DoctorController
{
	 private DoctorService doctorService;

	    private SettlePointService settlePointService;
	    

	    @Autowired
	    public DoctorController(DoctorService doctorService, SettlePointService settlePointService) {
	        this.doctorService = doctorService;
	        this.settlePointService = settlePointService;
	    }
	    
	    @GetMapping("/doctors/{id}")
	    public String getDoctor(@PathVariable long id, Model model) {
	        DoctorViewModel doctorViewModel = this.doctorService.getViewModelById(id);

	        model.addAttribute("doctorViewModel", doctorViewModel);

	        return "doctor/doctor";
	    }
	    
	    @GetMapping("/register-doctor")
	    public String getDoctorRegister(@ModelAttribute DoctorRegistrationModel doctorRegistrationModel, Model model) {
	        List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
	        model.addAttribute("settlePoints", settlePoints);

	        return "doctor/register";
	    }
	    
	    @GetMapping("/doctor/edit")
	    public String getEditDoctor(Model model, Authentication principal) {
	        List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
	        model.addAttribute("settlePoints", settlePoints);

	        long userId = ((User) principal.getPrincipal()).getId();
	        EditDoctorModel editDoctorModel = this.doctorService.getEditModelByUserId(userId);

	        model.addAttribute("editDoctorModel", editDoctorModel);

	        return "doctor/edit";
	    }

}
