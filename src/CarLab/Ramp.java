package CarLab;

import java.util.Stack;

//TODO: Make an interface over this so CarTransport can have several different ramps?

/**
 * A Car-type transporting class. Can be raised and lowered. Will only accept Cars that are up to maxLength i length.
 * Uses a stack for storing the Cars.
 */
public class Ramp {
    private final int capacity;
    private final Stack<Car> cars = new Stack<>();
    private final double maxLength = 300;
    private boolean raised;

    /**
     * Creates a Ramp-instance and defines its capacity and sets is raised status to true.
     * @param capacity is the number of cars the ramp can hold.
     */
    public Ramp(int capacity) {
        this.capacity = capacity;
        this.raised = true;
    }

    /**
     * A getter for how many cars there are in the stack numberOfCars.
     * @return Returns int value from numberOfCars.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Raises the ramp.
     */
    public void raise(){
        raised = true;
    }

    /**
     * Lowers the ramp.
     */
    public void lower() {
        raised = false;
    }

    /**
     * @return boolean if ramp is raised.
     */
    public boolean isRaised() {
        return raised;
    }

    /**
     * Loads (adds) a car object to the top of the cars stack. Does so if the ramp angle is close or equal to the max
     * ramp angle, the car is small enough and if the ramp has capacity.
     * @param car The Car object to be added to the cars stack.
     * @return boolean if the action succeeded and the car could be loaded.
     */
    public boolean loadCar(Car car) {
        if (cars.size() < capacity && !raised && car.getLength() <= maxLength) {
            cars.add(car);
            return true;
        } else { return false; }
    }

    /**
     * Unloads (and removes) the car on the top of the cars-stack. If the cars-stack is empty then an exception
     * thrown.
     * @return Returns the car at the top of the cars stack if there is one.
     * @throws ArrayIndexOutOfBoundsException
     */
    public Car unLoadCar() throws ArrayIndexOutOfBoundsException {
        if (cars.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There is no cars on the ramp to unload.");
        }
        return cars.pop();
    }

    /**
     * Gets the stack of Cars.
     */
    public Stack<Car> getCars() {
        return cars;
    }

}
