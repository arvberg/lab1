import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrucksTest {
    private Trucks scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @Test
    void invalidAngleTest(){
        for (int i = 0; i < 100; i++) {
            ((Scania) scania).tiltFlatbed(1);
        }
        assertEquals(70, ((Scania) scania).getFlatbedAngle());
        for (int i = 0; i < 100; i++){
            ((Scania) scania).tiltFlatbed(-1);
        }
        assertEquals(0, ((Scania) scania).getFlatbedAngle());
    }

    @Test
    void invalidMoveTest(){
        ((Scania) scania).tiltFlatbed(1);
        assertThrows(IllegalArgumentException.class, () -> scania.startEngine());
    }

}
