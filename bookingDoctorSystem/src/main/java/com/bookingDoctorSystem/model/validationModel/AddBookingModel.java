package com.bookingDoctorSystem.model.validationModel;

import java.util.Date;

import javax.validation.constraints.Size;

import com.bookingDoctorSystem.entity.Doctor;
import com.bookingDoctorSystem.entity.Patient;

public class AddBookingModel 
{
	    private Date date;


	    @Size(max = 256, message = "Invalid description length")
	    private String description;

	    private Patient patient;

	    private Doctor doctor;

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Patient getPatient() {
	        return patient;
	    }

	    public void setPatient(Patient patient) {
	        this.patient = patient;
	    }

	    public Doctor getDoctor() {
	        return doctor;
	    }

	    public void setDoctor(Doctor doctor) {
	        this.doctor = doctor;
	    }
}
