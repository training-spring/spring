package hello;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable

public class ProjectEmployeePk implements Serializable {

    private Employee employee;
    private Project project;
    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }


    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        ProjectEmployeePk that = (ProjectEmployeePk) o;

        if (employee !=null?!employee.equals(that.employee) : that.employee !=null) return false;
        if (project !=null?!project.equals(that.project) : that.project !=null)
            return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        int result;
        result = (employee !=null ? employee.hashCode() : 0);
        result =31* result + (project !=null? project.hashCode() : 0);
        return result;
    }
}
