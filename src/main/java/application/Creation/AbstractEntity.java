package application.Creation;

import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

// @MappedSuperclass  Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.
@MappedSuperclass
public abstract class AbstractEntity {

    //@ID Specifies the primary key of an entity.
    @Id
    //@GeneratedValue GeneratedValue Provides for the specification of generation strategies for the values of primary keys.
    @GeneratedValue

    @Type(type = "uuid-char")
    private UUID id;

    public UUID getId(){
        return id;
    }
    public void setId(UUID id){
        this.id = id;
    }
    @Override
    public int hashCode(){
        if(id != null){
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof AbstractEntity)){
            return false;
        }
        AbstractEntity other = (AbstractEntity) obj;

        if(id != null){
            return id.equals(other.id);
        }
        return super.equals(other);
    }
}
