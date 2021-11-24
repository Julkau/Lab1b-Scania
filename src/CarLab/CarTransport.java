package CarLab;

import java.awt.*;

public class CarTransport extends Car{
    private final Ramp ramp;

    public CarTransport(int doors, double enginePower, Color color, String name) {
        super(doors, enginePower, color, name);
        this.ramp = new Ramp(4);
    }

    @Override
    protected double speedFactor() {
        if(ramp.isRaised()) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    public void raiseRamp() {
        if(getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    public void lowerRamp() {
        if(getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

    public boolean loadCar(Car car) {
        return ramp.loadCar(car);
    }

    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

    @Override
    public void move() {
        super.move();
        Double[] carTransportCoordinate = getCoordinate();
        for(Car car : ramp.getCars()){
            car.setCoordinate(carTransportCoordinate);
        }
    }

    @Override
    public void gas(double amount) throws IllegalArgumentException {
        if(ramp.isRaised()) {
            super.gas(amount);
        }
    }
}
