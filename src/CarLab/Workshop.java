package CarLab;

import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private final int maxCapacity;
    private int currentCapacity;
    private List<T> cars = new ArrayList<>();

    public Workshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void storeCar(T car) throws ArrayStoreException{
        if(currentCapacity < maxCapacity) {
            cars.add(car);
            currentCapacity++;
        } else {
            throw new ArrayStoreException("Can't store car in Workshop, it is full!");
        }
    }

    public void getCar(T car) {
        for (int i = 0; i<currentCapacity; i++){
            if (cars.get(i).getLicensePlate().equals(car.getLicensePlate())){
                cars.remove(i);
                currentCapacity--;
                break;
            }
        }
    }
}
