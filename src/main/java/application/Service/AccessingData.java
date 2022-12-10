package application.Service;

import application.Creation.CreateWorker;
import application.Creation.Hours;
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
        return groupRepo.count();
    }
    public void deleteWorker(CreateWorker worker){
        groupRepo.delete(worker);
    }

    public void saveContact(CreateWorker worker){
        if(worker == null){
            System.err.println("CreateWorker is null. Are you sure you have connected your form to the application?");
            return;
        }
        groupRepo.save(worker);
    }
    public List<CreateWorker> findAllHours(String filterText){return groupRepo.findAll();}
    //public List<Hours> findAllHours(){return groupRepo.findAll();}
   // public List<> findAllSpec(){return specrepo.findAll();}

}
