package com.husky.controllers;

import com.husky.entities.Request;
import com.husky.repositories.RequestRepository;
import com.husky.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class RequestController {
    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private RequestRepository requestRepository;

    @RequestMapping(value ="/{employeeId}/requests", method = RequestMethod.GET)
    public List<Request> getRequestsByEmployeeId(@PathVariable(value = "employeeId") Long employeeId){
        return requestRepository.findByEmployeeId(employeeId);
    }

    @RequestMapping(value="/{employeeId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "employeeId") Long employeeId,
                                 @RequestBody Request request){
        return employeeRepository.findById(employeeId).map(employee -> {
            request.setEmployee(employee);
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("Employee id" + employeeId + "Not Found"));
    }
}
