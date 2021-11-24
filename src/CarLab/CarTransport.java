package CarLab;

import java.awt.*;

public class CarTransport extends Car{
    private final Ramp ramp;

    public CarTransport(int doors, double enginePower, Color color, String name, int rampCapacity) {
        super(doors, enginePower, 7.5, color, name);
        this.ramp = new Ramp(rampCapacity);
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
        if(closeBy(car)) {
            return ramp.loadCar(car);
        }
        return false;
    }

    public Car unLoadCar() {
        Car car = ramp.unLoadCar();
        setUnloadCoordinate(car);
        return car;
    }

    private void setUnloadCoordinate(Car car) {
        DIRECTION direction = getDirection();
        Double[] coordinate = car.getCoordinate();
        double x = coordinate[0];
        double y = coordinate[1];

        if (direction == DIRECTION.NORTH) {
            setCoordinate(x,y-1);
        } else if (direction == DIRECTION.EAST) {
            setCoordinate(x-1,y);
        } else if (direction == DIRECTION.SOUTH) {
            setCoordinate(x,y+1);
        } else if (direction == DIRECTION.WEST) {
            setCoordinate(x+1,y);
        }
    }

    private boolean closeBy(Car car) {
        Double[] coordinateCar = car.getCoordinate();
        double carX = coordinateCar[0];
        double carY = coordinateCar[1];

        Double[] coordinate = getCoordinate();
        double truckX = coordinate[0];
        double truckY = coordinate[1];

        double distance = Math.sqrt(Math.pow(carX-truckX, 2) + Math.pow(carY-truckY, 2));
        return distance <= 1;
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
