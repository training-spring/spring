package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

@SpringBootApplication
public class Application {

    /*@Autowired
    private PersonRepository repository;*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}