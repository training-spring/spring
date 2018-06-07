package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String location;
	private String name;
	private int number;

	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}