package application.Service;

import Creation.CreateWorker;
import Creation.Hours;
import Creation.Spec;
import application.repository.HoursRepository;
import application.repository.SpecRepository;
import application.repository.WorkersRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccessingData {
    private final WorkersRepository workersRepo;
    private final HoursRepository hoursrepo;
    private final SpecRepository specrepo;
    public AccessingData(WorkersRepository workersRepo, HoursRepository hoursRepo, SpecRepository specRepo){
        this.workersRepo = workersRepo;
        this.hoursrepo = hoursRepo;
        this.specrepo = specRepo;
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
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
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