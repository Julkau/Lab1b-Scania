package CarLab;

import java.util.Stack;

public class Ramp{
    private final int capacity;
    private final double maxRampAngle;
    private double rampAngle;
    private final Stack<Car> cars = new Stack<>();

    public Ramp(int capacity, double maxRampAngle) {
        this.capacity = capacity;
        this.rampAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle.
     * @param amount The amount to increase rampAngle by.
     * @return Returns double value from the new ramp value
     */
    public double raiseRamp(double amount) {
        return rampAngle = Math.min(getRampAngle() + amount, maxRampAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle.
     * @param amount The amount to reduce rampAngle by.
     * @return Returns double value from the new ramp value
     */
    public double lowerRamp(double amount) {
        return rampAngle = Math.max(getRampAngle() - amount, 0);
    }

    /**
     * A getter for how many cars there are in the stack numberOfCars.
     * @return Returns int value from numberOfCars.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    // TODO: Make sure cars don't add more cars than capacity! How do we make the user understand that max capacity is reached?
    // Return bool value with it being true if the car was loaded and false if it was not?

    /**
     * Load car method adds a car object to the top of the cars stack if the ramp angle is close or equal
     * to the max ramp angle the and the ramp's capacity.
     * @param car The Car object to be added to the cars stack.
     */
    public void loadCar(Car car) {
        if (getRampAngle() > maxRampAngle-5 && cars.size() < capacity) {
            cars.add(car);
        }
    }

    /**
     * Un load car method removes the car on the top of the cars stack, if the cars stack is empty then an exception is throw.n
     * @return Returns the car at the top of the cars stack if there is one.
     * @throws NegativeArraySizeException NegativeArraySizeException
     */
    public Car unLoadCar() throws NegativeArraySizeException {
        if (cars.size() == 0) {
            throw new NegativeArraySizeException("There is no cars on the ramp to unload.");
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
