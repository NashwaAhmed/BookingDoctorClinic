package com.bookingDoctorSystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking implements Serializable 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name = "date")
	    private Date date;

	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private Doctor doctor;

	    @Column(name = "description")
	    private String description;

	    public Booking()
	    {
	    	
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
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

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
}
