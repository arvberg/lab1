import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Cars implements hasFlatBed {
    private boolean isRampDown = false;
    private ArrayList<Cars> cars = new ArrayList<>();
    private int maxSize;
    private final int maxDistanceAllowed = 3;

    public CarTransport(int maxSize) {
        super(2, 700, Color.WHITE, "Scania");
        this.maxSize = maxSize;
    }

    private boolean isMoving() {
        return (this.getCurrentSpeed() > 0);
    }

    public void lowerRamp() {
        if (isMoving()) {
            throw new IllegalAccessError("Can't lower ramp while moving");
        }
        isRampDown = true;
    }

    public void raiseRamp() {
        if (isMoving()) {
            throw new IllegalAccessError("Can't raise ramp while moving");
        }
        isRampDown = false;
    }

    public void addCar(Cars car) {
        if (car.getPosition().distance(this.getPosition()) > maxDistanceAllowed) {
            throw new IllegalArgumentException("Can't add car, it's too far away");
        }
        if (car instanceof hasFlatBed) {
            throw new IllegalArgumentException("Can't add a car with a flatbed");
        }
        if (cars.size() >= maxSize) {
            throw new IllegalArgumentException("...");
        }
        if (isRampDown == false) {
            throw new IllegalArgumentException("Can't add car while the ramp is up");
        }
        cars.add(car);
    }

    public Cars getLastCar() {
        if (isRampDown == false) {
            throw new IllegalAccessError("Can't get the last car while the ramp is up");
        }
        if (cars.size() == 0) {
            throw new IllegalAccessError("Can't get the last car of an empty flatBed");
        }

        Cars lastCar = cars.remove(cars.size() - 1);

        return lastCar;
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
