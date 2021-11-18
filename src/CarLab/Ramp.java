package CarLab;

import java.util.Stack;

public class Ramp {
    private int capacity;
    private double rampAngle;
    private double maxRampAngle;
    private Stack<Car> cars = new Stack<>();

    public Ramp(int capacity, double maxRampAngle) {
        this.capacity = capacity;
        this.rampAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    public void raiseRamp() {

    }

    public void lowerRamp() {

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
}
