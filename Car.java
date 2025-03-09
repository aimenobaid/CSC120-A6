import java.util.ArrayList;

/**
 * The Car class represents a passenger car in a train.
 * It implements CarRequirements and manages passenger capacity and occupancy.
 */

 public class Car implements CarRequirements {
    private int capacity;
    private ArrayList<Passenger> passengers;

    /**
     * Constructor for Car
     * @param capacity Maximum number of passengers the car can hold
     */
    public Car(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int seatsRemaining() {
        return this.capacity - this.passengers.size();
    }

    /**
     * Adds a passenger to the car if space is available.
     * @param p Passenger to be added
     * @return true if successful, false if car is full
     */
    public Boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passengers.add(p);
            return true;
        }
        return false;
    }

    /**
     * Removes a passenger from the car if they are onboard.
     * @param p Passenger to be removed
     * @return true if successful, false if passenger not found
     */
    
 public Boolean removePassenger(Passenger p) {
        return passengers.remove(p);
    }

    /**
     * Prints the list of passengers in the car.
     */
    public void printManifest() {
        if (passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            for (Passenger p : passengers) {
                System.out.println(p.getName());
            }
        }
    }
}
