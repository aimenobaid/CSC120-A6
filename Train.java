import java.util.ArrayList;

/**
 * The Train class ties together the engine and cars to form a complete train.
 * It implements TrainRequirements and manages passengers across multiple cars.
 */

public class Train implements TrainRequirements{
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor for Train
     * @param fuelType Type of fuel used
     * @param currentFuelLevel Initial fuel level
     * @param fuelCapacity Maximum fuel capacity
     * @param nCars Number of passenger cars
     * @param passengerCapacity Capacity per passenger car
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Car getCar(int i) {
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }
        return null;
    }

    public int getMaxCapacity() {
        int totalCapacity = 0;
        for (Car car : cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }

    public int seatsRemaining() {
        int totalSeats = 0;
        for (Car car : cars) {
            totalSeats += car.seatsRemaining();
        }
        return totalSeats;
    }

    /**
     * Prints the manifest of all passengers onboard.
     */
    public void printManifest() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + (i + 1) + ":");
            cars.get(i).printManifest();
        }
    }
}

