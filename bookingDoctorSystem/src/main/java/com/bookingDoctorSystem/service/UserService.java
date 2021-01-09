package com.bookingDoctorSystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bookingDoctorSystem.entity.User;
import com.bookingDoctorSystem.model.validationModel.ChangePasswordModel;
import com.bookingDoctorSystem.model.validationModel.UserRegistrationModel;

public interface UserService extends UserDetailsService{

	    User register(UserRegistrationModel registrationModel);

	    boolean updatePassword(ChangePasswordModel changePasswordModel);
}
