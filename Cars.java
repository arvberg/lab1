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

    public Cars(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        this.position = new Point(0, 0);
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

    public String getDirection() {
        return direction;
    }

    public String getModelName() {
        return modelName;
    }

    // setters
    public void setColor(Color clr) {
        color = clr;
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

    // changers
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    protected abstract double speedFactor();

    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
        decrementSpeed(amount);
    }

    public void move() {
        if (currentSpeed > 0) {
            switch (direction) {
                case "left" -> position.x--;
                case "right" -> position.x++;
                case "up" -> position.y++;
                case "down" -> position.y--;
                default -> {
                }
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
