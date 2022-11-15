import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerPayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setConstructor() {
        WorkerPay newPay = new WorkerPay(30, 10.50);
        assertEquals(30,newPay.getHours());
        assertEquals(10.50,newPay.getRate());
        assertEquals(315,newPay.getNormalPay());
        assertEquals(0,newPay.getOvertimePay());
        assertEquals(0,newPay.getOvertime());
        assertEquals(315,newPay.getTotalPay());
    }

    @Test
    void getOvertime() {
        WorkerPay newPay = new WorkerPay(40, 10.50);
        assertEquals(35,newPay.getHours());
        assertEquals(367.5,newPay.getNormalPay());
        assertEquals(78.75,newPay.getOvertimePay());
        assertEquals(5,newPay.getOvertime());
        assertEquals(446.25,newPay.getTotalPay());
    }

    @Test
    void getHoursFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new WorkerPay(-5, 10.50));
        assertEquals("This is not a valid amount of hours", exMessage.getMessage());
    }

    @Test
    void getRateFail() {
        Exception exMessage = assertThrows(IllegalArgumentException.class, ()-> new WorkerPay(35, 9.50));
        assertEquals("This is not a valid rate", exMessage.getMessage());
    }

    @AfterEach
    void tearDown() {
    }
}