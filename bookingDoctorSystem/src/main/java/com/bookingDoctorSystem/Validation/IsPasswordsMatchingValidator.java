package com.bookingDoctorSystem.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordsMatchingValidator implements ConstraintValidator<IsPasswordsMatching, Object>
{

	@Override
	public void initialize(IsPasswordsMatching constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		 return value instanceof PasswordConfirmable &&
	                ((PasswordConfirmable) value).getPassword().equals(((PasswordConfirmable) value).getConfirmPassword());
	}

}
