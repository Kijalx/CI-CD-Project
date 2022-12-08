package Creation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class CreateWorker extends AbstractEntity {
    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    @Email
    @NotEmpty
    private String email = "";

    @ManyToOne
    @JoinColumn(name = "spec_id")
    @NotNull
    @JsonIgnoreProperties({"workers"})
    private Hours hours;
    @NotNull
    @ManyToOne
    private Spec spec;
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hours getHours() {
        return hours;
    }
    public void setHours(Hours hours){
        this.hours = hours;
    }

    public void setSpec(Spec spec){
        this.spec = spec;
    }
    public Spec getSpec(){
        return spec;
    }
}
