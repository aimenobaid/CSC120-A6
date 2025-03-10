import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class for Train, Engine, Car, and Passenger classes.
 */

public class TrainTest {
    private Engine engine;
    private Car car;
    private Passenger passenger;
    private Train train;

    @Before
    public void setUp() {
        engine = new Engine(FuelType.STEAM, 100.0, 200.0);
        car = new Car(2);
        passenger = new Passenger("John Doe");
        train = new Train(FuelType.STEAM, 150.0, 300.0, 3, 5);
    }

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        assertEquals(FuelType.STEAM, engine.getFuelType());
        assertEquals(100.0, engine.getCurrentFuel(), 0.01);
        assertEquals(200.0, engine.getMaxFuel(), 0.01);
    }

    @Test
    public void testEngineGo() {
        double initialFuel = engine.getCurrentFuel();
        engine.go();
        assertTrue(engine.getCurrentFuel() < initialFuel);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        assertTrue(car.addPassenger(passenger));
        assertEquals(1, car.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        car.addPassenger(passenger);
        assertTrue(car.removePassenger(passenger));
        assertEquals(2, car.seatsRemaining());
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        passenger.boardCar(car);
        assertEquals(1, car.seatsRemaining());
    }

    @Test
    public void testPassengerBoardCarFull() {
        car.addPassenger(new Passenger("Amelia"));
        car.addPassenger(new Passenger("Buddy"));
        passenger.boardCar(car);
        assertEquals(0, car.seatsRemaining());
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        assertNotNull(train.getEngine());
        assertEquals(3, train.getMaxCapacity() / 5);
    }

    @Test
    public void testTrainPassengerCount() {
        Car firstCar = train.getCar(0);
        firstCar.addPassenger(passenger);
        assertEquals(14,train.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        assertNotNull(train.getCar(0));
        assertNull(train.getCar(5));
    }

    @Test
    public void testTrainPrintManifest() {
        train.getCar(0).addPassenger(passenger);
        train.printManifest();
    }
    
}
