package com.bookingDoctorSystem.Validation;

import java.lang.annotation.*;


import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IsPasswordsMatchingValidator.class)
public @interface IsPasswordsMatching
{
	    String message() default "Passwords not matching";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
}
