import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Cars> {
    private final int maxCapacity;
    private final List<T> storedCars;

    public Garage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.storedCars = new ArrayList<>();
    }

    public void addCar(T car) {
        if (storedCars.size() >= maxCapacity) {
            throw new IllegalStateException("Garage is full.");
        }
        storedCars.add(car);
    }

    public T returnCar() {
        if (storedCars.isEmpty()) {
            throw new IllegalStateException("No cars in garage.");
        }
        return storedCars.removeLast();
    }

    public List<T> getCarList() {
        return new ArrayList<>(storedCars);
    }
}
