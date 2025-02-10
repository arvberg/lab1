
import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Cars implements HasFlatBed {
    private boolean isRampDown = false;
    private ArrayList<Cars> cars = new ArrayList<>();
    private int maxSize = 6;
    private final int maxDistanceAllowed = 3;

    public CarTransport() {
        super(2, 700, Color.WHITE, "Scania");
    }

    private boolean isMoving() {
        return (this.getCurrentSpeed() > 0);
    }

    // Helper method to check if the ramp is down
    private void setRamp(boolean down) {
        if (isMoving()) {
            throw new IllegalAccessError("Can't adjust ramp while moving");
        }
        isRampDown = down;
    }

    public void lowerRamp() {
        setRamp(true);
    }

    public void raiseRamp() {
        setRamp(false);
    }

    public void addCar(Cars car) {
        if (!isRampDown) {
            throw new IllegalArgumentException("Can't add car while the ramp is up");
        }
        if (car.getPosition().distance(this.getPosition()) > maxDistanceAllowed) {
            throw new IllegalArgumentException("Can't add car, it's too far away");
        }
        if (car instanceof HasFlatBed) {
            throw new IllegalArgumentException("Can't add a car with a flatbed");
        }
        if (cars.size() >= maxSize) {
            throw new IllegalArgumentException("Can't add more cars, max capacity reached");
        }
        cars.add(car);
    }

    public Cars getLastCar() {
        if (!isRampDown) {
            throw new IllegalAccessError("Can't get the last car while the ramp is up");
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Can't get the last car of an empty flatbed");
        }

        return cars.remove(cars.size() - 1);
    }

    @Override
    public void move() {
        super.move();
        for (Cars car : cars) {
            car.setPosition(this.getPosition());
        }
    }

    @Override
    public void startEngine() {
        if (isRampDown) {
            throw new IllegalArgumentException("Can't move vehicle while the ramp is down.");
        }
        super.startEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }
}
