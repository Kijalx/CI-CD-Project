package Creation;

import org.hibernate.annotations.Formula;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Hours extends AbstractEntity{
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "hours")
    @Nullable
    private List<CreateWorker> employees = new LinkedList<>();

    @Formula("(select count(c.id) from CreateWorker c where c.spec_id = id)")
    private int employeeCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreateWorker> getEmployees() {
        return employees;
    }

    public void setEmployees(List<CreateWorker> employees) {
        this.employees = employees;
    }

    public int getEmployeeCount(){
        return employeeCount;
    }
}
