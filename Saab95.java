import java.awt.*;

public class Saab95 extends Cars {

    public Saab95() {
        super(2, 125, Color.RED, "Saab95");
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (getTurbo()) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}