import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public abstract class Transport<T extends Cars> {
    private final int maxCapacity;
    private final Stack<T> loadedVehicles;

    public Transport(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.loadedVehicles = new Stack<>();
    }

    public boolean canLoad(T vehicle) {
        return loadedVehicles.size() < maxCapacity;
    }

    public void loadVehicle(T vehicle) {
        if (!canLoad(vehicle)) {
            throw new IllegalStateException("Transport is full!");
        }
        loadedVehicles.push(vehicle);
    }

    public T unloadVehicle() {
        if (loadedVehicles.isEmpty()) {
            throw new IllegalStateException("No vehicles to unload!");
        }
        return loadedVehicles.pop();
    }

    public List<T> getLoadedVehicles() {
        return new ArrayList<>(loadedVehicles);
    }
}
