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
        CreateWorker newWorker = new CreateWorker("Aleks", "Kijewski","GB12ABCD10203012345678", "AAAABBCCDDD", 11, "aleks@gmail.com");
        assertEquals("Aleks",newWorker.getFirstName());
        assertEquals("Kijewski",newWorker.getLastName());
        assertEquals("GB12ABCD10203012345678",newWorker.getIban());
        assertEquals("AAAABBCCDDD",newWorker.getBic());
        assertEquals(11,newWorker.getRate());
        assertEquals("aleks@gmail.com",newWorker.getEmail());
    }

    @Test
    void getFirstNameFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("A", "Kijewski","GB12ABCD10203012345678", "AAAABBCCDDD", 11,"aleks@gmail.com"));
        assertEquals("This is not a valid name must be 3 or more characters", exMessage.getMessage());
    }

    @Test
    void getLastNameFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks", "Ki","GB12ABCD10203012345678", "AAAABBCCDDD", 11,"aleks@gmail.com"));
        assertEquals("This is not a valid name must be 3 or more characters", exMessage.getMessage());
    }

    @Test
    void getIbanFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","Kijewski","GB12ABCD1020301234567", "AAAABBCCDDD", 11,"aleks@gmail.com"));
        assertEquals("This is not a valid iban", exMessage.getMessage());
    }

    @Test
    void getBicFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","Kijewski","GB12ABCD10203012345678", "AAAABBC", 11,"aleks@gmail.com"));
        assertEquals("This is not a valid bic", exMessage.getMessage());
    }

    @Test
    void getRateFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","Kijewski","GB12ABCD10203012345678", "AAAABBCCDDD", 9,"aleks@gmail.com"));
        assertEquals("This is not a rate", exMessage.getMessage());
    }

    @Test
    void getEmailFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new CreateWorker("Aleks","Kijewski","GB12ABCD10203012345678", "AAAABBCCDDD", 11,"ail.com"));
        assertEquals("This is not a valid email must include @", exMessage.getMessage());
    }

    @AfterEach
    void tearDown() {
    }
}