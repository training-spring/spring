package main.java.hello;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Workfor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL)
    private Department department;

    public void setEmployee(Employe employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){
        return this.department;
    }  
	
}
