
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTest {
    private Scania scania;

    @BeforeEach
    void setup() {
        scania = new Scania();
    }

    @Test
    void raiseRampTest() {
        scania.startEngine();
        assertThrows(IllegalArgumentException.class, () -> scania.raiseRamp());
    }

    @Test
    void startEngineRampUpTest() {
        scania.raiseRamp();
        assertThrows(IllegalArgumentException.class, () -> scania.startEngine());
    }

    // Edge case flatBed
    @Test
    void negativeRampAngleTest() {
        scania.lowerRamp();
        assertEquals(scania.getFlatBedAngle(), 0);
    }

    @Test
    void maxRampAngleTest() {
        for (int i = 0; i < 10; i++) {
            scania.raiseRamp();
        }
        assertEquals(scania.getFlatBedAngle(), 70);
    }

    @Test
    void invalidRampAngleTest() {
        assertThrows(IllegalArgumentException.class, () -> scania.setRampAngle(-1));
        assertThrows(IllegalArgumentException.class, () -> scania.setRampAngle(71));
    }

    @Test
    void setRampAngleTest() {
        scania.setRampAngle(35);
        assertEquals(scania.getFlatBedAngle(), 35);
    }

    @Test
    void setInvalidRampAngleTest() {
        assertThrows(IllegalArgumentException.class, () -> scania.setRampAngle(-1));
        assertThrows(IllegalArgumentException.class, () -> scania.setRampAngle(71));
    }
}
