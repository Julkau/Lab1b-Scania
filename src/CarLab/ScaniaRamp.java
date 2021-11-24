package CarLab;

import java.util.Stack;

public class ScaniaRamp implements Ramp {
    private final int capacity;
    private final double maxRampAngle;
    private double rampAngle;
    private final Stack<Car> cars = new Stack<>();

    public ScaniaRamp(int capacity, double maxRampAngle) {
        this.capacity = capacity;
        this.rampAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle to a max angle of maxRampAngle.
     * @param amount The amount to increase rampAngle by.
     * @return Returns double value from the new ramp value
     */

    public void raiseRamp(double amount) {
        rampAngle = Math.min(getRampAngle() + amount, maxRampAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle, to a min angle of 0.
     * @param amount The amount to reduce rampAngle by.
     * @return Returns double value from the new ramp value
     */
    public void lowerRamp(double amount) {
        rampAngle = Math.max(getRampAngle() - amount, 0);
    }

    /**
     * A getter for how many cars there are in the stack numberOfCars.
     * @return Returns int value from numberOfCars.
     */
    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Load car method adds a car object to the top of the cars stack if the ramp angle is close or equal
     * to the max ramp angle the and the ramp's capacity.
     * @param car The Car object to be added to the cars stack.
     * @return boolean if the action succeeded and the car could be loaded.
     */
    @Override
    public boolean loadCar(Car car) {
        if (getRampAngle() > maxRampAngle-5 && cars.size() < capacity) {
            cars.add(car);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Un load car method removes the car on the top of the cars stack, if the cars stack is empty then an exception is throw.n
     * @return Returns the car at the top of the cars stack if there is one.
     * @throws ArrayIndexOutOfBoundsException
     */
    @Override
    public Car unLoadCar() throws ArrayIndexOutOfBoundsException {
        if (cars.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There is no cars on the ramp to unload.");
        }
        return cars.pop();
    }

    /**
     * Getter for the attribute rampAngle
     * @return Returns double value from rampAngle
     */
    public double getRampAngle() {
        return rampAngle;
    }

    public Stack<Car> getCars() {
        return cars;
    }
}
