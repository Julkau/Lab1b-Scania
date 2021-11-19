package CarLab;

import java.awt.*;

public class Scania extends Car {

    private final Ramp ramp;

    public Scania() {
        super(2,100,Color.white,"CarLab.Scania");
        ramp = new Ramp(4, 70);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    public void loadCar(Car car) {
        ramp.loadCar(car);
    }

    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

    public double raiseRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            return ramp.raiseRamp(amount);
        }else{
            return (0);
        }
    }

    public double lowerRamp(double amount) {
        if (getCurrentSpeed() == 0) {
            return ramp.lowerRamp(amount);
        }else{
            return (0);
        }
    }
}
