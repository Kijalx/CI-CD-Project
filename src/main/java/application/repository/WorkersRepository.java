package application.repository;

import Creation.CreateWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkersRepository extends JpaRepository<CreateWorker, Integer> {
    @Query("select c from CreateWorker c " +
            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<CreateWorker> search(@Param("searchTerm") String searchTerm);
}