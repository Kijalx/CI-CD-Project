package application.repository;

import application.Creation.CreateWorker;
import application.Creation.Hours;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<CreateWorker, Long> {

}

