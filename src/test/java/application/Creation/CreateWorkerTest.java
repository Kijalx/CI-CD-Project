package application.Creation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Junit testing for CreateWorkers class
class CreateWorkerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setFirstName() {
        CreateWorker worker = new CreateWorker();
        worker.setFirstName("Aleks");
        assertEquals("Aleks",worker.getFirstName());
    }

    @Test
    void setLastName() {
        CreateWorker worker = new CreateWorker();
        worker.setLastName("Kijewski");
        assertEquals("Kijewski",worker.getLastName());
    }
    @Test
    void setEmail() {
        CreateWorker worker = new CreateWorker();
        worker.setEmail("Alekskijewski@gmail.com");
        assertEquals("Alekskijewski@gmail.com",worker.getEmail());
    }
    @Test
    void setFirstNameFail() {
        CreateWorker worker = new CreateWorker();
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> worker.setFirstName("a"));
        assertEquals("Not a valid first name", exMessage.getMessage()); // Collects exception error
    }

    @Test
    void setLastNameFail() {
        CreateWorker worker = new CreateWorker();
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> worker.setLastName("ae"));
        assertEquals("Not a valid last name", exMessage.getMessage()); // Collects exception error
    }
    @Test
    void setEmailFail() {
        CreateWorker worker = new CreateWorker();
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> worker.setEmail("aleksdjafngmail.com"));
        assertEquals("Not a valid email", exMessage.getMessage()); // Collects exception error
    }

    @AfterEach
    void tearDown() {
    }
}