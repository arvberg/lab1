import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {

    @BeforeEach
    void setup() {
    }

    @Test
    void addCarTest() {
        Garage<Cars> garage = new Garage<Cars>(10);
        Cars volvo240 = new Volvo240();
        Cars saab = new Saab95();
        garage.addCar(volvo240);
        garage.addCar(saab);
        assertEquals(saab, garage.getCar(1));
        assertEquals(volvo240, garage.getCar(0));
    }

    @Test
    void addCarTestVolvo() {
        Garage<Volvo240> garage = new Garage<Volvo240>(10);
        Cars volvo240 = new Volvo240();
        garage.addCar((Volvo240) volvo240);
        assertEquals(volvo240, garage.getCar(0));

        /* Gives static type error */
        // Saab95 x = garage.getCar(0);

        /* Gives static type error */
        // Cars saab = new Saab95();
        // garage.addCar(saab);

    }

    @Test
    void addMaxCarsTest() {
        Garage<Cars> garage = new Garage<Cars>(1);
        Cars volvo240 = new Volvo240();
        garage.addCar(volvo240);
        assertThrows(IllegalArgumentException.class, () -> garage.addCar(new Saab95()));
    }

    @Test
    void addSameCarTwiceTest() {
        Garage<Cars> garage = new Garage<Cars>(10);
        Cars volvo240 = new Volvo240();
        garage.addCar(volvo240);
        assertThrows(IllegalArgumentException.class, () -> garage.addCar(volvo240));
    }

    @Test
    void getCarTest() {
        Garage<Cars> garage = new Garage<Cars>(10);
        Cars volvo240 = new Volvo240();
        garage.addCar(volvo240);
        assertEquals(volvo240, garage.getCar(0));
        assertThrows(IllegalStateException.class, () -> garage.getCar(1));
    }

    @Test
    void getLastCarTest() {
        Garage<Cars> garage = new Garage<Cars>(10);
        Cars volvo240 = new Volvo240();
        Cars saab = new Saab95();
        garage.addCar(volvo240);
        garage.addCar(saab);
        assertEquals(saab, garage.getLastCar());
        assertEquals(volvo240, garage.getLastCar());
    }

    @Test
    void getInvalidIndexTest() {
        Garage<Cars> garage = new Garage<Cars>(10);
        assertThrows(IllegalStateException.class, () -> garage.getCar(0));
    }

}
