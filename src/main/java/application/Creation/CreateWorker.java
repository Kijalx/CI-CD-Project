package application.Creation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Worker creation class

// @ Entity Specifies that the class is an entity.
@Entity
@Table(name = "CREATEWORKER")
public class CreateWorker extends AbstractEntity {

    //The @NotEmpty annotation makes use of the @NotNull class' isValid() implementation, and also checks that the size/length of the supplied object  is greater than zero.
    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    //@ManyToOne Specifies a single-valued association to another entity class that has many-to-one multiplicity.
    @ManyToOne
    //@joinColumn Specifies a column for joining an entity association or element collection.
    @JoinColumn(name = "hours_id")
    @NotNull

    //@JsonIgnoreProperties is used at class level to mark a property or list of properties to be ignored.
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
    public void setHours(Hours hours){this.hours = hours;}

    public void setSpec(Spec spec){
        this.spec = spec;
    }
    public Spec getSpec(){
        return spec;
    }
}
