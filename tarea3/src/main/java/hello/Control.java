package main.java.hello;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Control {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Projects projects;

    @OneToMany(cascade = CascadeType.ALL)
    private Department department;

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){
        return this.department;
    }  

    public void setProjects(Projects projects){
        this.projects = projects;
    }

    public Projects getProjects(){
        return this.projects;
    }  
	
}