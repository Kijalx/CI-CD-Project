import Creation.CreateWorker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateWorkerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructor(){
        CreateWorker newWorker = new CreateWorker("Aleks","GB12ABCD10203012345678", "AAAABBCCDDD", 10.50, "aleks@gmail.com");
        assertEquals("Aleks",newWorker.getName());
        assertEquals("GB12ABCD10203012345678",newWorker.getIban());
        assertEquals("AAAABBCCDDD",newWorker.getBic());
        assertEquals(10.50,newWorker.getRate());
        assertEquals("aleks@gmail.com",newWorker.getEmail());
    }

    @Test
    void getNameFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("A","GB12ABCD10203012345678", "AAAABBCCDDD", 10.50,"aleks@gmail.com"));
        assertEquals("This is not a valid name must be 3 or more characters", exMessage.getMessage());
    }

    @Test
    void getIbanFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","GB12ABCD1020301234567", "AAAABBCCDDD", 10.50,"aleks@gmail.com"));
        assertEquals("This is not a valid iban", exMessage.getMessage());
    }

    @Test
    void getBicFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","GB12ABCD10203012345678", "AAAABBC", 10.50,"aleks@gmail.com"));
        assertEquals("This is not a valid bic", exMessage.getMessage());
    }

    @Test
    void getRateFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","GB12ABCD10203012345678", "AAAABBCCDDD", 10,"aleks@gmail.com"));
        assertEquals("This is not a rate", exMessage.getMessage());
    }

    @Test
    void getEmailFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","GB12ABCD10203012345678", "AAAABBCCDDD", 10,"ail.com"));
        assertEquals("This is not a rate", exMessage.getMessage());
    }

    @AfterEach
    void tearDown() {
    }
}