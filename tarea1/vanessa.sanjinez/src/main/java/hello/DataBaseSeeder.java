package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBaseSeeder implements CommandLineRunner{
    private PersonRepository customerRepository;

    @Autowired
    public DataBaseSeeder(PersonRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        List<Person> customerList = new ArrayList<>();

        customerList.add(new Person("Juan", "Perez", new Address("Bolivia", "Cochabamba")));
        customerList.add(new Person("Juan1", "Perez1", new Address("Argentina", "Argentina1")));
        customerList.add(new Person("Juan2", "Perez1", new Address("Peru", "Peru1")));

        customerRepository.saveAll(customerList);
    }
}
