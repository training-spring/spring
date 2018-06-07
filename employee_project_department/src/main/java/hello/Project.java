package hello;
import java.util.List;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Cascade;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Entity
//@Table(name ="project")
public class Project {

    private Long id;
    private String name;
    private List<ProjectEmployee> projectEmployees =new LinkedList<ProjectEmployee>();

    public Project() {
    }

    @Id
    @GenericGenerator(name ="generator", strategy ="increment")
    @GeneratedValue(generator ="generator")
    @Column(name ="project_id", nullable =false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name ="name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Here is the annotation to add in order to
     * Hibernate to automatically insert and update
     * ProducEmployees (if any)
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.project", cascade = 
    {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
    org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    public List<ProjectEmployee> getProjectEmployees() {
        return this.projectEmployees;
    }

    public void setProjectEmployees(List<ProjectEmployee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }
}
