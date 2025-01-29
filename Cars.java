import java.awt.*;

public abstract class Cars implements Movable {

    // variables
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point position; // The car's current position
    private String direction; // The car's current direction
    private boolean turboOn = false; // If the turbo is on or off

    public Cars(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        this.position = new Point(0, 0);
        this.direction = "up";

        stopEngine();
    }

    // getters
    public int getNrDoors() {
        return nrDoors;
    }

    public Color getColor() {
        return color;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Point getPosition() {
        return position;
    }

    public int getX() {
        return position.x;
    }

    public int getY() {
        return position.y;
    }

    public String getDirection() {
        return direction;
    }

    public String getModelName() {
        return modelName;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    // setters
    public void setColor(Color color) {
        this.color = color;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    private boolean isValidAmount(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
        return true;
    }

    // changers
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    protected abstract double speedFactor();

    public void gas(double amount) {
        if (isValidAmount(amount)) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (isValidAmount(amount)) {
            decrementSpeed(amount);
        }
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public void move() {
        if (currentSpeed > 0) {
            switch (direction) {
                case "left":
                    position.x -= currentSpeed;
                    break;
                case "right":
                    position.x += currentSpeed;
                    break;
                case "up":
                    position.y += currentSpeed;
                    break;
                case "down":
                    position.y -= currentSpeed;
                    break;
                default:
                    break;
            }
        }
    }

    public void turnLeft() {
        if (direction == null) {
            throw new IllegalArgumentException("Direction must be set before turning.");
        }
        switch (direction) {
            case "left" -> direction = "down";
            case "right" -> direction = "up";
            case "up" -> direction = "left";
            case "down" -> direction = "right";
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    public void turnRight() {
        if (direction == null) {
            throw new IllegalArgumentException("Direction must be set before turning.");
        }
        switch (direction) {
            case "left" -> direction = "up";
            case "right" -> direction = "down";
            case "up" -> direction = "right";
            case "down" -> direction = "left";
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
