package main.java.hello;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Workon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToMany(cascade = CascadeType.ALL)
    private Projects projects;

    private String startdate;
    private String duration;

    public void setEmployee(Employe employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setProjects(Projects projects){
        this.projects = projects;
    }

    public Projects getProjects(){
        return this.projects;
    }

    public void setStartdate(String startdate){
        this.startdate = startdate;
    }

    public String getStartdate(){
        return this.startdate;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getDuration(){
        return this.duration;
    }  
	
}
