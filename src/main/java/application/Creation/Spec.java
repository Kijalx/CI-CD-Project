package application.Creation;

import javax.persistence.Entity;

//Spec Class

@Entity
public class Spec extends AbstractEntity{
    private String name;

    public Spec() {

    }

    public Spec(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
