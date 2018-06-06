package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import java.util.Date;


@Entity
public class WorkOn{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date startdate;
	private double duration;

	@ManyToOne(cascade= CascadeType.ALL)
	private Employee employee;

	@ManyToOne(cascade= CascadeType.ALL)
	private Projects projects;

	public WorkOn(){}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

}
