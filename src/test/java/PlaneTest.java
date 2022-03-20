import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrew;
import people.crew.CrewType;
import people.crew.Pilot;
import people.passenger.Passenger;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;
    private Pilot pilot;
    private Plane bigPlane;
    private Plane weePlane;
    private CabinCrew flightAttendant;
    private CabinCrew firstOfficer;
    private ArrayList<CabinCrew> crew1;
    private ArrayList<CabinCrew> crew2;
    private Passenger pass1;
    private Passenger pass2;
    private Passenger pass3;

    @Before
    public void before(){
        pilot = new Pilot("Jimmy", CrewType.FIRST_OFFICER, "AYY69");
        flightAttendant = new CabinCrew("Sandra", CrewType.FLIGHT_ATTENDANT);
        firstOfficer = new CabinCrew("Spock", CrewType.FIRST_OFFICER);
        crew1 = new ArrayList<>();
        crew1.add(flightAttendant);
        crew1.add(firstOfficer);
        crew2 = new ArrayList<>();
        crew2.add(firstOfficer);
        pass1 = new Passenger("Bobby", 1);
        pass2 = new Passenger("John", 2);
        pass3 = new Passenger("Eric", 3);
        bigPlane = new Plane(PlaneType.BOEING747, 306.0);
        weePlane = new Plane(PlaneType.CESSNA172, 7.0);
    }

    @Test
    public void canCalcBaggageAllowance(){
        assertEquals(3.5, weePlane.calculateBaggageAllowance(), 0);
        assertEquals(153.0, bigPlane.calculateBaggageAllowance(), 0);
    }

    @Test
    public void canCalcIndividualBagAllowance(){
        assertEquals(0.875, weePlane.calculateIndividualBagAllowance(), 0);
        assertEquals(0.414, bigPlane.calculateIndividualBagAllowance(), 0.1);
    }

}
