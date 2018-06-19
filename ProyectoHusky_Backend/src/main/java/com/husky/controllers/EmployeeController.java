package com.husky.controllers;

import com.husky.entities.Employee;
import com.husky.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Inject
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeById (@PathVariable long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    
}