package com.husky.controllers;

import com.husky.entities.Request;
import com.husky.exception.ResourceNotFoundException;
import com.husky.repositories.RequestRepository;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
/**
 * Created by Luis on 04/06/2018.
 */
@RestController
@RequestMapping(value = "/users")
public class RequestController {
    @Inject
    private UserRepository userRepository;

    @Inject
    private RequestRepository requestRepository;

    @RequestMapping(value = "/{userId}/requests", method = RequestMethod.GET)
    public List<Request> getRequestsByUserId(@PathVariable(value = "userId") Long userId){
        return requestRepository.findByUserId(userId);
    }
    /*@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "userId") Long userId, @RequestBody Request request){
        return userRepository.findById(userId).map(user -> {
            request.setUser(user);
            return requestRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("User id" + userId + "Not Found"));
    }*/

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "userId") Long userId, @RequestBody Request request){
        return userRepository.findById(userId).map(user -> {
            request.setUser(user);
            if(validateDate(request.getFloatingHolidayDateRequest())){
                return requestRepository.save(request);
            }
            return null;
        }).orElseThrow(() -> new ResourceNotFoundException("User id" + userId + "Not Found"));
    }

    public boolean validateDate(Date requestDate){
        int day,month,year;
        LocalDate today;
        LocalDate twoDaysEarly;

        LocalDate daterequested = LocalDate.of(requestDate.getYear(),requestDate.getMonth(),requestDate.getDate());

        day = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonth().getValue();
        year = LocalDate.now().getYear();
        today = LocalDate.of(year, month, day);

        if(daterequested.isBefore(today.plusDays(2)))
            return false;
        else
            return true;
    }
}
