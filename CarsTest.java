import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Volvo240 volvo;
    private Saab95 saab;

    @BeforeEach
    void setUp() {
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    void testCarInitialization() {
        assertEquals(4, volvo.getNrDoors());
        assertEquals(2, saab.getNrDoors());
        assertEquals(100, volvo.getEnginePower());
        assertEquals(125, saab.getEnginePower());
    }

    @Test
    void testStartStopEngine() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());

        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void testGas() {
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() > 0.1);
    }

    @Test
    void testBrake() {
        volvo.startEngine();
        volvo.gas(0.5);
        double speedBefore = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() < speedBefore);
    }

    @Test
    void testTurbo() {
        saab.setTurboOn();
        double speedFactorOn = saab.speedFactor();
        saab.setTurboOff();
        double speedFactorOff = saab.speedFactor();
        assertTrue(speedFactorOn > speedFactorOff);
    }

    @Test
    void testMove() {
        volvo.startEngine();
        volvo.move();
    }

    @Test
    void testTurnLeft() {
        volvo.turnLeft();
    }

    @Test
    void testTurnRight() {
        volvo.turnRight();

    }
    @Test
    void gas_IncreasesSpeedWithinLimits() {
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() > initialSpeed);
        assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower());
    }

    @Test
    void gas_DoesNotAcceptInvalidValues() {
        double initialSpeed = volvo.getCurrentSpeed();
        volvo.gas(-0.5);
        assertEquals(initialSpeed, volvo.getCurrentSpeed());
        volvo.gas(1.5);
        assertEquals(initialSpeed, volvo.getCurrentSpeed());
    }

    @Test
    void brake_DecreasesSpeedWithinLimits() {
        volvo.startEngine();
        volvo.gas(1);
        double speedBeforeBrake = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() < speedBeforeBrake);
        assertTrue(volvo.getCurrentSpeed() >= 0);
    }

    @Test
    void brake_DoesNotAcceptInvalidValues() {
        double initialSpeed = volvo.getCurrentSpeed();
        volvo.brake(-0.5);
        assertEquals(initialSpeed, volvo.getCurrentSpeed());
        volvo.brake(1.5);
        assertEquals(initialSpeed, volvo.getCurrentSpeed());
    }

    @Test
    void gas_DoesNotDecreaseSpeed() {
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() >= initialSpeed);
    }

    @Test
    void brake_DoesNotIncreaseSpeed() {
        volvo.startEngine();
        volvo.gas(1);
        double speedBeforeBrake = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() <= speedBeforeBrake);
    }
}

}
