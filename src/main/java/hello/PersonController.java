package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
@RestController
@RequestMapping("/persons")

public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPerson(@RequestBody Person newPerson){
        personService.addPerson(newPerson);
    }

    /*@RequestMapping("/search/findByCountry")
    public List<Person> listPersonForCountry(@RequestParam(value = "country", defaultValue = "Bolivia") String country){
        return personService.findByCountry(country);
    }*/
}