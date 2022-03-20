import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrew;
import people.crew.CrewType;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {

    private CabinCrew cabinCrew;

    @Before
    public void before(){
        cabinCrew = new CabinCrew("Jimmy", CrewType.FLIGHT_ATTENDANT);
    }
    
    @Test
    public void hasRank(){
        assertEquals(CrewType.FLIGHT_ATTENDANT, cabinCrew.getRank());
    }

    @Test
    public void canMakeAnnouncement(){
        String announcement = "Grab your ankles boys, we're heading for the Pyrenees.";
        assertEquals("Grab your ankles boys, we're heading for the Pyrenees.", cabinCrew.makeAnnouncement(announcement));
    }
}
