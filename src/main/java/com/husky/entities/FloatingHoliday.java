package com.husky.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Luis on 03/06/2018.
 */
@Entity
public class FloatingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floatingHolidayId")
    private Long id;
    private Date date;
    private int  hour;
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    private boolean userParent;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "floatingHoliday")
    private Collection<Request> requests;

    public FloatingHoliday() {
    }

    public FloatingHoliday(Date date, int hour, Gender userGender, boolean userParent, String description) {
        this.date = date;
        this.hour = hour;
        this.userGender = userGender;
        this.userParent = userParent;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public boolean isUserParent() {
        return userParent;
    }

    public void setUserParent(boolean userParent) {
        this.userParent = userParent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Request> getRequests() {
        return requests;
    }

    public void setRequests(Collection<Request> requests) {
        this.requests = requests;
    }
}
