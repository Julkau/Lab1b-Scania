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
        setCarCoordinate(car);
        return ramp.loadCar(car);
    }

    public Car unLoadCar() {
        return ramp.unLoadCar();
    }

    private void setCarCoordinate(Car car) {
        Double[] coordinate = getCoordinate();
        double x = coordinate[0];
        double y = coordinate[1];

        if (getDirection() == DIRECTION.NORTH) {
            car.setCoordinate(x, y-1);
        } else if (getDirection() == DIRECTION.EAST) {
            car.setCoordinate(x-1, y);
        } else if (getDirection() == DIRECTION.SOUTH) {
            car.setCoordinate(x, y+1);
        } else if (getDirection() == DIRECTION.WEST) {
            car.setCoordinate(x+1, y);
        }
    }

    @Override
    public void gas(double amount) throws IllegalArgumentException {
        if(ramp.isRaised()) {
            super.gas(amount);
        }
    }
}
