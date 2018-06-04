package hello;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Address address;

    public Person() {}

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%s, firstName='%s', lastName='%s' , address = '%s']",
                id, firstName, lastName, address);
    }

}