import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRamp {

    @Test
    public void load_cars_to_ramp(){
        Car volvo240 = new Volvo240();
        Car saab95 = new Saab95();
        Ramp ramp = new Ramp(4,70);
        ramp.loadCar(volvo240);
        System.out.println(ramp.getCars());
    }

    @Test
    public void cars_unloads_in_order(){
        Car volvo240 = new Volvo240();
        Car saab95 = new Saab95();
        Ramp ramp = new Ramp(4,70);
        ramp.loadCar(volvo240);
        ramp.loadCar(saab95);
        System.out.println(ramp.getCars());
        ramp.unLoadCar();
        System.out.println(ramp.getCars());
    }

    @Test
    public void unloadcars_should_raise_exception_if_unloading_cars_while_stack_is_empty(){
        Ramp ramp = new Ramp(4,70);
        assertThrows(NegativeArraySizeException.class, () -> ramp.unLoadCar());

    }

    @Test
    public void raising_ramp_angle_above_max_capacity_should_stop_at_max_capacity(){
        Ramp ramp = new Ramp(4, 70);
        ramp.raiseRamp(50);
        System.out.println(ramp.getRampAngle());
        ramp.raiseRamp(100);
        System.out.println(ramp.getRampAngle());
    }

    @Test
    public void cannot_lower_ramp_below_0_degrees(){
        Ramp ramp = new Ramp(4,70);
        ramp.raiseRamp(10);
        ramp.lowerRamp(20);
        System.out.println(ramp.getRampAngle());

    }


}
