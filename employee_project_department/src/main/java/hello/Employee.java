package hello;
import java.util.List;
import java.util.LinkedList;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;


@Entity
//@Table(name ="employee")
public class Employee {

    private Long id;
    private String firstName;
    private List<ProjectEmployee> projectEmployees = new LinkedList<ProjectEmployee>();


    private Department department;

    public Employee() {
    }

    @Id
    @GenericGenerator(name ="generator", strategy ="increment")
    @GeneratedValue(generator ="generator")
    //@Column(name ="employee_id", nullable =false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@Column(name ="name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.employee")
    public List<ProjectEmployee> getProjectEmployees() {
        return this.projectEmployees;
    }

    public void setProjectEmployees(List<ProjectEmployee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
