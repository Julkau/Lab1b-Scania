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

    public void storeCar(T car) throws ArrayStoreException{
        //något
    }

    public void getCar(T car) {
        //något
    }
}
