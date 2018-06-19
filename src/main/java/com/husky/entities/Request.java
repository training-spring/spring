package com.husky.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Luis on 03/06/2018.
 */
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateSend;
    private String statusRequest;
    private String descriptionRequest;
    private Date floatingHolidayDateRequest;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "userId", nullable = false)
    @JsonIgnore
    private User user;
    @ManyToOne
    //@JoinColumn(name = "floatingHolidayId", nullable = false)
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "floating", referencedColumnName = "floatingHolidayId", nullable = false)
    private FloatingHoliday floatingHoliday;

    public Request() {
    }

    public Request(Date dateSend, String statusRequest, String descriptionRequest, Date floatingHolidayDateRequest, FloatingHoliday floatingHoliday) {
        this.dateSend = dateSend;
        this.statusRequest = statusRequest;
        this.descriptionRequest = descriptionRequest;
        this.floatingHolidayDateRequest = floatingHolidayDateRequest;
        this.floatingHoliday = floatingHoliday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public String getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(String statusRequest) {
        this.statusRequest = statusRequest;
    }

    public String getDescriptionRequest() {
        return descriptionRequest;
    }

    public void setDescriptionRequest(String descriptionRequest) {
        this.descriptionRequest = descriptionRequest;
    }

    public Date getFloatingHolidayDateRequest() {
        return floatingHolidayDateRequest;
    }

    public void setFloatingHolidayDateRequest(Date floatingHolidayDateRequest) {
        this.floatingHolidayDateRequest = floatingHolidayDateRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FloatingHoliday getFloatingHoliday() {
        return floatingHoliday;
    }

    public void setFloatingHoliday(FloatingHoliday floatingHoliday) {
        this.floatingHoliday = floatingHoliday;
    }
}
