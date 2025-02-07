import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

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
        for (int i = 0; i < 100; i++) {
            scania.raiseRamp();
        }
        assertEquals(scania.getFlatBedAngle(), 70);
    }

}
