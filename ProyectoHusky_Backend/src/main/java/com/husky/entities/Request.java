package com.husky.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_request")
    private long id;
    private Date dateSendRequest;
    private String status;
    private Date floatingHolidayDateRequest;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_floating")
    public FloatingHoliday floatingHoliday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateSendRequest() {
        return dateSendRequest;
    }

    public void setDateSendRequest(Date dateSendRequest) {
        this.dateSendRequest = dateSendRequest;
    }


    public Date getFloatingHolidayDateRequest() {
        return floatingHolidayDateRequest;
    }

    public void setFloatingHolidayDateRequest(Date floatingHolidayDateRequest) {
        this.floatingHolidayDateRequest = floatingHolidayDateRequest;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public FloatingHoliday getFloatingHoliday() {
        return floatingHoliday;
    }

    public void setFloatingHoliday(FloatingHoliday floatingHoliday) {
        this.floatingHoliday = floatingHoliday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}