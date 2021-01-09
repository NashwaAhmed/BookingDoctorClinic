package com.bookingDoctorSystem.Validation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = IsBGTelephoneMatchingValidator.class)
public @interface BGTelephone 
{
	String message() default "Invalid telephone number.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
