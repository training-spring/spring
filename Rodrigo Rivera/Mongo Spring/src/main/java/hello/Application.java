package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();

		person1.setFirstName("person1");
		person1.setLastName("last1");
		person1.setAddress(new Address("country1", "city1"));

		repository.save(person1);		
	}*/
}