package main.java.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Name {

    private String firstName;
    private String lastName; 

    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    public String getFirstName() {
        return firstName;
    }   

    public void setLastName(String lastName) {
		this.lastName = lastName;
    }
    
	public String getLastName() {
		return lastName;
	}	
}
