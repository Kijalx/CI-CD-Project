import Creation.CreateWorker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<CreateWorker, Long>{
    List<CreateWorker>findCreateWorkerByiD(int iD);
}
