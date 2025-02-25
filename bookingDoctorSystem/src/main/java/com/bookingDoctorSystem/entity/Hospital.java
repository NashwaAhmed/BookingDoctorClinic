package com.bookingDoctorSystem.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hospital")
public class Hospital implements Serializable
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name = "name")
	    private String name;

	    @ManyToOne
	    @JoinColumn(name = "settle_point_id")
	    private SettlePoint settlePoint;
	    
	    @OneToMany
	    @JoinColumn(name = "doctor_id")
	    private Set<Doctor> doctor;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "telephone")
	    private String telephone;

	    @Column(name = "website")
	    private String website;

	    @Column(name = "description")
	    private String description;

	    public Hospital() 
	    {
	    	
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public SettlePoint getSettlePoint() {
	        return settlePoint;
	    }

	    public void setSettlePoint(SettlePoint settlePoint) {
	        this.settlePoint = settlePoint;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getWebsite() {
	        return website;
	    }

	    public void setWebsite(String website) {
	        this.website = website;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
}
