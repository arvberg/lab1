import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTransportTest {
    private Cars volvo240;
    private Cars saab;
    private CarTransport carTransport;
    private final int maxSizeTransport = 6;

    @BeforeEach
    void setup() {
        carTransport = new CarTransport(maxSizeTransport);
        volvo240 = new Volvo240();
        saab = new Saab95();
    }

    @Test
    void addGetCarTest() {
        carTransport.lowerRamp();
        carTransport.addCar(volvo240);
        carTransport.addCar(saab);
        assertEquals(saab, carTransport.getLastCar());
        assertEquals(volvo240, carTransport.getLastCar());
    }

    @Test
    void addCarRampUp() {
        assertThrows(IllegalArgumentException.class, () -> carTransport.addCar(volvo240));
    }

    @Test
    void addCarTooFarAway() {
        carTransport.lowerRamp();
        volvo240.startEngine();
        volvo240.gas(1);
        for (int i = 0; i < 10; i++) {
            volvo240.move();
        }
        assertThrows(IllegalArgumentException.class, () -> carTransport.addCar(volvo240));
    }

    @Test
    void moveCarsAndCarTransport() {
        carTransport.lowerRamp();
        carTransport.addCar(volvo240);
        carTransport.raiseRamp();

        carTransport.startEngine();
        carTransport.gas(1);
        carTransport.move();

        assertEquals(carTransport.getPosition(), volvo240.getPosition());
    }

    @Test
    void addCarTransportToCarTransport() {
        CarTransport carTransport2 = new CarTransport(maxSizeTransport);
        carTransport.lowerRamp();
        assertThrows(IllegalArgumentException.class, () -> carTransport.addCar(carTransport2));
    }

    @Test
    void addScaniaToCarTransport() {
        Scania scania = new Scania();
        carTransport.lowerRamp();
        assertThrows(IllegalArgumentException.class, () -> carTransport.addCar(scania));
    }

}
