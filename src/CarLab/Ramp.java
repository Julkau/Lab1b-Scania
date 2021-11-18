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

    public void loadCar() {

    }

    public Car unLoadCar() {
        return null;
    }

    public double getRampAngle() {return rampAngle;}
}
