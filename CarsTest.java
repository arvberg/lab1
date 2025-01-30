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
        volvo.setPosition(new Point(0, 0));
        volvo.setDirection("up");

        saab = new Saab95();
        saab.setPosition(new Point(0, 0));
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
    }

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
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor());
        saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor());
    }

    @Test
    void getterSetterTests(){
        volvo.setColor(Color.RED);
        assertEquals(Color.RED, volvo.getColor());
        volvo.setNrDoors(2);
        assertEquals(2, volvo.getNrDoors());
        volvo.setModelName("Volvo E72");
        assertEquals("Volvo E72", volvo.getModelName());
    }

    // Edge-case testing

    @Test
    void invalidGasBrakeTest() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(1.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(1.1));
    }

    @Test // Won't fall below 0 or over enginePower due to our format in Cars.java
    void invalidSpeedTest(){
        volvo.startEngine();
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed());
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed());

        for (int i = 0; i < 100; i++){
            volvo.gas(1);
        }
        assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower());
    }
}