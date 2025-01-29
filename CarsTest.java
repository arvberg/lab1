import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    private Cars volvo;
    private Cars saab;

    @BeforeEach
    void setup() {
        volvo = new Volvo240();
        volvo.setDirection("up");

        saab = new Saab95();
        saab.setDirection("up");
    }

    @Test
    void engineTest() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());
        volvo.gas(1);
        volvo.move();
        assertEquals(new Point(0, 1), volvo.getPosition());
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void turnTest() {
        volvo.turnLeft();
        assertEquals("left", volvo.getDirection());
        volvo.turnRight();
        assertEquals("up", volvo.getDirection());
    } // turns are simple and in a pattern, full rotations are unnecessary to test if
      // just two work.

    @Test
    void speedFactorTest() {
        assertEquals(1.25, volvo.speedFactor());
    }

    @Test
    void speedLimitTest() {
        volvo.startEngine();
        volvo.gas(1);
        assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower());
        volvo.brake(1);
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    void gasBrakeTest() {
        volvo.startEngine();
        volvo.gas(1);
        assertEquals(1.35, volvo.getCurrentSpeed());
        volvo.brake(0.1);
        assertEquals(1.225, volvo.getCurrentSpeed());
    }

    @Test
    void turboToggleTest() {
        saab.startEngine();
        ((Saab95) saab).setTurboOn();
        assertEquals(1.625, saab.speedFactor());
        ((Saab95) saab).setTurboOff();
        // saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor());
    }

    // Edge-case tests

    @Test
    void invalidGasTest() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(1.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(1.1));
    }

}