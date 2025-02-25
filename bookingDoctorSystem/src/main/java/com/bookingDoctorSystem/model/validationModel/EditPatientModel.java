package com.bookingDoctorSystem.model.validationModel;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.bookingDoctorSystem.Validation.BGTelephone;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EditPatientModel 
{
	 private long id;

	    @Size(min = 5, message = "First name too short")
	    private String firstName;

	    @Size(min = 5, message = "Last name too short")
	    private String lastName;

	    @BGTelephone
	    private String telephoneNumber;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "PST")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @NotNull(message = "Invalid date of birth")
	    private Date dateOfBirth;

	    private Date dateOfEnrollment;

	    @NotBlank(message = "Invalid gender.")
	    @Pattern(regexp = "^(MALE|FEMALE)$", message = "Invalid gender.")
	    private String gender;

	    private String doctorFirstName;

	    private String doctorLastName;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }


	    public String getTelephoneNumber() {
	        return telephoneNumber;
	    }

	    public void setTelephoneNumber(String telephoneNumber) {
	        this.telephoneNumber = telephoneNumber;
	    }

	    public Date getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(Date dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }

	    public Date getDateOfEnrollment() {
	        return dateOfEnrollment;
	    }

	    public void setDateOfEnrollment(Date dateOfEnrollment) {
	        this.dateOfEnrollment = dateOfEnrollment;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getDoctorFirstName() {
	        return doctorFirstName;
	    }

	    public void setDoctorFirstName(String doctorFirstName) {
	        this.doctorFirstName = doctorFirstName;
	    }

	    public String getDoctorLastName() {
	        return doctorLastName;
	    }

	    public void setDoctorLastName(String doctorLastName) {
	        this.doctorLastName = doctorLastName;
	    }
}
