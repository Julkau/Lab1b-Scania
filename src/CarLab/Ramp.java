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

    public double raiseRamp(double amount) {
        return rampAngle = Math.min(getRampAngle() + amount, maxRampAngle);
    }

    public double lowerRamp(double amount) {
        return rampAngle = Math.max(getRampAngle() - amount, 0);
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    // TODO: Make sure cars don't add more cars than capacity! How do we make the user understand that max capacity is reached?
    public void loadCar(Car car) {
        cars.add(car);
    }

    public Car unLoadCar() throws NegativeArraySizeException {
        if (cars.size() == 0) {
            throw new NegativeArraySizeException("There is no cars on the ramp to unload.");
        }
        return cars.pop();
    }

    public double getRampAngle() {
        return rampAngle;
    }

    public Stack<Car> getCars() {
        return cars;
    }
}
