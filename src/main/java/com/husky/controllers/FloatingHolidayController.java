package com.husky.controllers;

import com.husky.entities.FloatingHoliday;
import com.husky.entities.User;
import com.husky.repositories.FloatingHolidayRepository;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
@RestController
public class FloatingHolidayController {
    @Inject
    private FloatingHolidayRepository floatingHolidayRepository;
    @Inject
    private UserRepository userRepository;
    @RequestMapping(value = "/floatings", method = RequestMethod.GET)
    public List<FloatingHoliday> getAllFloating(){
        return floatingHolidayRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/floatings/{name}", method = RequestMethod.GET)
    public FloatingHoliday getFloatingByName(@PathVariable String name){
        return floatingHolidayRepository.findByDescription(name);
    }

    @RequestMapping(value = "/floatings", method = RequestMethod.POST)
    public FloatingHoliday addFloating(@RequestBody FloatingHoliday newFloating){
        return floatingHolidayRepository.save(newFloating);
    }
    @RequestMapping(value = "/users/{userId}/floatings", method = RequestMethod.GET)
    public List<FloatingHoliday> getAllFloatingByUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).get();
        return floatingHolidayRepository.findByUserGenderAndUserParent(user.getGender(), user.isParent());
    }
}
