package application.repository;

import Creation.CreateWorker;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.startup.CredentialHandlerRuleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;

@SpringComponent
public class RandomDataGeneration {
    @Bean
    public CommandLineRunner loader(WorkersRepository workersRepo){
        return args -> {
            Logger logs = LoggerFactory.getLogger(getClass());
            if (workersRepo.count() != 0L) {
                logs.info("Using already made Repo");
                return;
            }
            int seed = 123;
            logs.info("Generating Demo Data");
            logs.info("Generating 50 Worker Entities");
            ExampleDataGenerator<CreateWorker> workerGenerator = new ExampleDataGenerator<>(CreateWorker.class,LocalDateTime.now());
            workerGenerator.setData(CreateWorker::setFirstName, DataType.FIRST_NAME);
            workerGenerator.setData(CreateWorker::setLastName, DataType.LAST_NAME);
            workerGenerator.setData(CreateWorker::setEmail,DataType.EMAIL);
            workerGenerator.setData(CreateWorker::setIban,DataType.IBAN);
            workerGenerator.setData(CreateWorker::setBic, DataType.IBAN);
            workerGenerator.setData(CreateWorker::setRate, DataType.AMOUNT_OF_MONEY);

            Random r = new Random(seed);
            List<CreateWorker> workers = workerGenerator.create(50,seed).stream().collect(Collectors.toList());

            workersRepo.saveAll(workers);
            logs.info("Created");
        };
    }
}