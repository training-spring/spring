package hello;

import org.springframework.data.annotation.Id;

public class Person {

	@Id private String id;

	private Address address;
	private String firstName;
	private String lastName;


	public Person(String firstName, String lastName, Address address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public Address getAddress(){
		return address;
	}

	public void setAddress(Address address){
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}