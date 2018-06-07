package hello;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.AssociationOverrides;
import javax.persistence.AssociationOverride;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

@Entity
@Table(name ="project_employee")
@AssociationOverrides({
@AssociationOverride(name ="pk.employee", joinColumns = @JoinColumn(name ="employee_id")),
@AssociationOverride(name ="pk.project", joinColumns = @JoinColumn(name ="project_id"))
        })
public class ProjectEmployee {

    private ProjectEmployeePk pk =new ProjectEmployeePk();

	public void setDuration(long duration){
		getPk().setDuration(duration);
	}

	@Transient
	public long getDuration(){
		return getPk().getDuration();
	}


    @EmbeddedId
    private ProjectEmployeePk getPk() {
        return pk;
    }

    private void setPk(ProjectEmployeePk pk) {
        this.pk = pk;
    }

    @Transient
    public Employee getEmployee() {
        return getPk().getEmployee();
    }

    public void setEmployee(Employee employee) {
        getPk().setEmployee(employee);
    }

    @Transient
    public Project getProject() {
        return getPk().getProject();
    }

    public void setProject(Project project) {
        getPk().setProject(project);
    }

    public boolean equals(Object o) {
        if (this== o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEmployee that = (ProjectEmployee) o;

        if (getPk() !=null?!getPk().equals(that.getPk()) : that.getPk() !=null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() !=null? getPk().hashCode() : 0);
    }
}
