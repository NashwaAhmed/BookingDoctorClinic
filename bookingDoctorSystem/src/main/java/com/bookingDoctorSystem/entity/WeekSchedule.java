package com.bookingDoctorSystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "week_schedules")
public class WeekSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booking_Duration")
    private int bookingDuration;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "weekSchedule")
    @OrderBy("id")
    private Set<DaySchedule> daySchedules;

    public WeekSchedule() {
        this.setDaySchedules(new HashSet());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(int bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    public Set<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void setDaySchedules(Set<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }
}
