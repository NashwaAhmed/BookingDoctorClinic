package com.bookingDoctorSystem.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class IsBGTelephoneMatchingValidator implements ConstraintValidator<BGTelephone, Object>
{

	@Override
	public void initialize(BGTelephone constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		    Pattern p = Pattern.compile("^\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})$");
	        Matcher m = p.matcher(value.toString());

	        return m.find();
	}

}
