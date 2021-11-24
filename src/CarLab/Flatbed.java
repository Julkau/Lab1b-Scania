package CarLab;

import java.util.Stack;

public class Flatbed {
    private final int capacity;
    private final Stack<Car> cars = new Stack<>();

    public Flatbed(int capacity) {
        this.capacity = capacity;
    }

    /**
     * A getter for how many cars there are in the stack numberOfCars.
     * @return Returns int value from numberOfCars.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Load car method adds a car object to the top of the cars stack if the ramp angle is close or equal
     * to the max ramp angle the and the ramp's capacity.
     * @param car The Car object to be added to the cars stack.
     * @return boolean if the action succeeded and the car could be loaded.
     */
    public boolean loadCar(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
            return true;
        } else { return false; }
    }

    /**
     * Un load car method removes the car on the top of the cars stack, if the cars stack is empty then an exception is throw.n
     * @return Returns the car at the top of the cars stack if there is one.
     * @throws ArrayIndexOutOfBoundsException
     */
    public Car unLoadCar() throws ArrayIndexOutOfBoundsException {
        if (cars.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There is no cars on the ramp to unload.");
        }
        return cars.pop();
    }

    public Stack<Car> getCars() {
        return cars;
    }

}
