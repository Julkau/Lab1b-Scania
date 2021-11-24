import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRamp {

    @Test
    public void car_size_should_be_at_zero_when_first_created(){
        Ramp ramp = new Ramp(70);
        assertEquals(0, ramp.getNumberOfCars());
    }

    @Test
    public void load_cars_to_ramp(){
        Car volvo240 = new Volvo240();
        Ramp ramp = new Ramp(70);
        ramp.loadCar(volvo240);
        assertEquals(1, ramp.getNumberOfCars());
    }

    @Test
    public void cars_unloads_in_order(){
        Car volvo240 = new Volvo240();
        Car saab95 = new Saab95();
        Ramp ramp = new Ramp(70);
        ramp.loadCar(volvo240);
        ramp.loadCar(saab95);
        System.out.println(ramp.getCars());
        ramp.unLoadCar();
        System.out.println(ramp.getCars());
    }

    @Test
    public void unloadcars_should_raise_exception_if_unloading_cars_while_stack_is_empty(){
        Ramp ramp = new Ramp(70);
        assertThrows(NegativeArraySizeException.class, ramp::unLoadCar);

    }
}
