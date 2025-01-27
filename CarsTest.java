import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    private Cars volvo;
    private Cars saab;

    @BeforeEach
    void setup(){
        volvo = new Volvo240();
        volvo.position = new Point(0,0);
        volvo.direction = "up";

        saab = new Saab95();
        saab.position = new Point(0,0);
        saab.direction = "up";
    }

    @Test
    void moveTest() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.01);
        assertEquals(new Point(0, 1), volvo.position);
    }

    @Test
    void engineTest() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    void turnLeftTest(){
        volvo.TurnLeft();
        assertEquals("left", volvo.direction);
        volvo.TurnLeft();
        assertEquals("down", volvo.direction);
        volvo.TurnLeft();
        assertEquals("right", volvo.direction);
        volvo.TurnLeft();
        assertEquals("up", volvo.direction);
    }

    @Test
    void speedFactorTest(){
        assertEquals(1.25, volvo.speedFactor(), 0.01);
    }

    @Test
    void saabNoTurboTest() {
        assertEquals(1.25, saab.speedFactor(), 0.01);
    }

    @Test
    void saabWithTurboTest() {
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(), 0.01);
    }

    @Test
    void saabTurboSpeedTest(){
        saab.startEngine();
        saab.setTurboOn();
        assertTrue(saab.getCurrentSpeed() > volvo.getCurrentSpeed());
    }
}
