/**
 * The Engine class represents the engine of a train.
 * It implements EngineRequirements and manages fuel type, current fuel level, and refueling.
 */
public class Engine implements EngineRequirements{
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    /**
    * Constructor for Engine
    * @param fuelType Type of fuel used
    * @param currentFuel Current amount of fuel
    * @param maxFuel Maximum fuel capacity
    */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel) {
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    public FuelType getFuelType() {
    return this.fuelType;
    }

    public double getMaxFuel() {
    return this.maxFuel;
    }

    public double getCurrentFuel() {
    return this.currentFuel;
    }

    /**
    * Refuels the engine to full capacity.
    */
    public void refuel() {
    this.currentFuel = this.maxFuel;
    }


    /**
     * Moves the train forward by consuming fuel.
     * @return true if the train can still move, false if out of fuel.
     */
    public Boolean go() {
        if (this.currentFuel > 0) {
            this.currentFuel -= 10; // some fuel consumption rate
            System.out.println("Choo choo! Fuel remaining: " + this.currentFuel);
            return true;
        } else {
            System.out.println("Out of fuel.");
            return false;
        }
    }
}

