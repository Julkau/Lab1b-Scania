import CarLab.Car;
import CarLab.Saab95;
import CarLab.Volvo240;
import CarLab.Workshop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWorkshop {

    @Test
    public void cannot_store_car_if_workshop_is_full(){
        Workshop workshop = new Workshop(1);
        Car saab95 = new Saab95("GYU438");
        Car volvo240 = new Volvo240("JZK991");
        workshop.storeCar(saab95);
        workshop.storeCar(volvo240);
        assertEquals(1, workshop.getCurrentCapacity());

    }

    @Test
    public void receives_the_right_car_when_getting_car_from_workshop(){
        Workshop workshop = new Workshop(5);
        Car saab95 = new Saab95("GYU438");
        Car volvo240 = new Volvo240("JZK991");
        workshop.storeCar(saab95);
        workshop.storeCar(volvo240);
        /** in progress .__. **/
    }


}
