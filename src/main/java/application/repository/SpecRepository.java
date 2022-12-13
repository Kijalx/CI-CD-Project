package application.repository;

import application.Creation.Spec;
import org.springframework.data.jpa.repository.JpaRepository;


//Jpa Repository For Job Spec
public interface SpecRepository extends JpaRepository<Spec, Integer> {
}
