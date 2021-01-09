package com.bookingDoctorSystem.model.validationModel;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.bookingDoctorSystem.Validation.BGTelephone;
import com.bookingDoctorSystem.Validation.IsPasswordsMatching;
import com.bookingDoctorSystem.Validation.PasswordConfirmable;
import com.fasterxml.jackson.annotation.JsonFormat;

@IsPasswordsMatching
public class PatientRegistrationModel implements PasswordConfirmable {

    @NotBlank(message = "Invalid email address")
    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 5, message = "Username too short")
    private String username;

    @Size(min = 5, message = "Password too short")
    private String password;

    @NotBlank
    private String confirmPassword;

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


    @NotBlank(message = "Invalid gender.")
    @Pattern(regexp = "^(MALE|FEMALE)$", message = "Invalid gender.")
    private String gender;

    private long doctor;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getDoctor() {
        return doctor;
    }

    public void setDoctor(long doctor) {
        this.doctor = doctor;
    }
}
