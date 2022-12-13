package application.repository;

import application.Creation.Hours;
import org.springframework.data.jpa.repository.JpaRepository;

//Jpa Repository For Hours

public interface HoursRepository extends JpaRepository<Hours, Integer> {
}
