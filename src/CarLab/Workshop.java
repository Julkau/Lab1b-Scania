package CarLab;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Workshop<T extends Car> {
    private final int maxCapacity;
    private int currentCapacity;
    private List<T> cars = new ArrayList<>();

    public Workshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
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

    public void getCar(T car) throws NoSuchElementException {
        for (int i = 0; i<currentCapacity; i++){
            if (cars.get(i).getLicensePlate().equals(car.getLicensePlate())){
                cars.remove(i);
                currentCapacity--;
                break;
            }
        }
        throw new NoSuchElementException("No car with matching licence plate could be found. ");
    }
}
