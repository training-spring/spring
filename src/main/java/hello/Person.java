package hello;

import org.springframework.data.annotation.Id;

public class Person {

	@Id private String id;

	private Address address;
	private String firstName;
	private String lastName;

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

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return this.address;
	}
}