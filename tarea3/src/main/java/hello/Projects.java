package main.java.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
    private String location;	
    
    public void setName(String name){
        this.name = name;
    }

	public String getName() {
		return name;
    }
    
    public void setLocation(String location){
        this.location = location;
    }

	public String getLocation() {
		return location;
	}  	
}
