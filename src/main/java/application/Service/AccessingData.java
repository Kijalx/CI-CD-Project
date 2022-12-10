package application.Service;

import application.Creation.CreateWorker;
import application.repository.GroupRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccessingData {
    private final GroupRepository groupRepo;
    public AccessingData(GroupRepository groupRepo){
        this.groupRepo = groupRepo;
    }
    public List<CreateWorker> findAllWorkers(String filterText){
        if(filterText == null || filterText.isEmpty()){
            return (List<CreateWorker>) groupRepo.findAll();
        }
        else{
            return groupRepo.search(filterText);
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
            System.err.println("CreateWorker is null. Are you sure you have connected your form to the application?");
            return;
        }
        workersRepo.save(worker);
    }
    public List<Hours> findAllHours(){
        return hoursrepo.findAll();
    }
    public List<Spec> findAllSpec(){
        return specrepo.findAll();
    }

}
