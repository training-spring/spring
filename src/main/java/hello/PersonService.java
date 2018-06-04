package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    private List<Person> list;
    public List<Person> getAllPerson(){
        List<Person> res = personRepository.findAll();
        return res;
    }

    public void addPerson(Person newPerson){
        personRepository.save(newPerson);
    }

    /*public List<Person> findByCountry(String country){
        list = new ArrayList<>();
        list.add((Person) personRepository.findByCountry(country));
        return list;
    }*/
}