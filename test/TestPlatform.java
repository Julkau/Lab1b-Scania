import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlatform {

    @Test
    public void raising_ramp_angle_above_max_capacity_should_stop_at_max_capacity(){
        Platform ramp = new Platform(70);
        ramp.raisePlatform(50);
        System.out.println(ramp.getAngle());
        ramp.raisePlatform(100);
        System.out.println(ramp.getAngle());
    }

    @Test
    public void cannot_lower_ramp_below_0_degrees(){
        Platform ramp = new Platform(70);
        ramp.raisePlatform(10);
        ramp.lowerPlatform(20);
        System.out.println(ramp.getAngle());

    }


}
