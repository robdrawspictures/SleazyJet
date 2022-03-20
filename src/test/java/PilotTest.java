import org.junit.Before;
import org.junit.Test;
import people.crew.CrewType;
import people.crew.Pilot;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Jimmy", CrewType.FIRST_OFFICER, "AYY69");
    }

    @Test
    public void canFlyPlane(){
        assertEquals("I feel the need. The need for speed.", pilot.chocksAway());
    }
}
