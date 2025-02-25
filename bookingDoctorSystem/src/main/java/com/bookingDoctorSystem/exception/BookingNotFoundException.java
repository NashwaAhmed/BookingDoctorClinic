package com.bookingDoctorSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such booking.")
public class BookingNotFoundException extends RuntimeException 
{

}
