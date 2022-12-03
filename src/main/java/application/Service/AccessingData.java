package application.Service;

import Creation.CreateWorker;
import application.repository.WorkersRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccessingData {
    private final WorkersRepository workersRepo;
    public AccessingData(WorkersRepository workersRepo){
        this.workersRepo = workersRepo;
    }
    public List<CreateWorker> findAllWorkers(String filterText){
        if(filterText == null || filterText.isEmpty()){
            return workersRepo.findAll();
        }
        else{
            return workersRepo.search(filterText);
        }
    }
    public long countWorkers(){
        return workersRepo.count();
    }
    public void deleteWorker(CreateWorker worker){
        workersRepo.delete(worker);
    }
    public void saveContact(CreateWorker worker){
        if(worker == null){
            throw new IllegalArgumentException("This worker is not valid");
        }

        workersRepo.save(worker);
    }
}