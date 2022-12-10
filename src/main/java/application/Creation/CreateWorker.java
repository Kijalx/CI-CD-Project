package application.Creation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CREATEWORKER")
public class CreateWorker extends AbstractEntity {
    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    @ManyToOne
    @JoinColumn(name = "hours_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Hours hours;
    @NotNull
    @ManyToOne
    private Spec spec;

    @Email
    @NotEmpty
    private String email = "";

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() > 3){
            this.firstName = firstName;
        }
        else{
            throw new IllegalArgumentException("Not a valid first name");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() > 3){
            this.lastName = lastName;
        }
        else{
            throw new IllegalArgumentException("Not a valid last name");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.contains("@") == true){
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("Not a valid email");
        }
    }

    public Hours getHours() {
        return hours;
    }
    public void setHours(Hours hours){this.hours = hours;}

    public void setSpec(Spec spec){
        this.spec = spec;
    }
    public Spec getSpec(){
        return spec;
    }
}
