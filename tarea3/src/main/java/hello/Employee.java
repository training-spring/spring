package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Name name;  

	private String address;
	private String sex;
	private Int age;
	private Long salary;
	private String contacts;
	private String dateofjoining;

	public void setName(Name name) {
		this.name = name;
	}
	
	public Name getName() {
		return this.name;
	}

	public void setAddress(String address){
    this.address = address;
  }

  public String getAddress(){
    return this.address;
	}
	
	public void setSex(String sex){
    this.sex = sex;
  }

  public String getSex(){
    return this.sex;
	}

	public void setAge(int age){
    this.age = age;
  }

  public Int getAge(){
    return this.age;
	}

	public void setSalary(Long salary){
    this.salary = salary;
  }

  public Long getSalary(){
    return this.salary;
	}

	public void setContacts(String contacts){
    this.contacts = contacts;
  }

  public String getContacts(){
    return this.contacts;
	}

	public void setDateOfJoining(String dateofjoining){
    this.dateofjoining = dateofjoining;
  }

  public String getDateOfJoining(){
    return this.dateofjoining;
	}
}
