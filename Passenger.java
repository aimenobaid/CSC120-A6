/**
 * The Passenger class represents a passenger who can board and exit train cars.
 * It implements PassengerRequirements and interacts with Car instances.
 */
public class Passenger implements PassengerRequirements {
    
    private String name;
    
    /**
     * Constructor for Passenger
     * @param name Passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Attempts to board a given car.
     * @param c The car to board
     */
    public void boardCar(Car c) {
        if (!c.addPassenger(this)) {
            System.out.println("Car is full! " + this.name + " couldn't board.");
        }
    }

    /**
     * Attempts to exit a given car.
     * @param c The car to exit
     */
    public void getOffCar(Car c) {
        if (!c.removePassenger(this)) {
            System.out.println(this.name + " was not in this car!");
        }
    }
}

