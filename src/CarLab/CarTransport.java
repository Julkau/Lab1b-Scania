package CarLab;

import java.awt.*;

public class CarTransport extends Car{
    private Ramp ramp;

    public CarTransport(int doors, double enginePower, Color color, String name) {
        super(doors, enginePower, color, name);
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    public void raiseRamp() {
        ramp.raiseRamp();
    }

    public void lowerRamp() {
        ramp.lowerRamp();
    }

    public boolean loadCar(Car car) {
        return ramp.loadCar(car);
    }

    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

}
