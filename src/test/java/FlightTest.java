import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrew;
import people.crew.CrewType;
import people.crew.Pilot;
import people.passenger.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight1;
    private Flight flight2;
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
    private ArrayList<Passenger> passengerRoster1;
    private ArrayList<Passenger> passengerRoster2;

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
        passengerRoster1 = new ArrayList<>();
        passengerRoster1.add(pass1);
        passengerRoster1.add(pass2);
        passengerRoster1.add(pass3);
        passengerRoster2 = new ArrayList<>();
        passengerRoster2.add(pass1);
        bigPlane = new Plane(PlaneType.BOEING747, 306.0);
        weePlane = new Plane(PlaneType.CESSNA172, 7.0);
        flight1 = new Flight(pilot, crew1, bigPlane, "XXX420", "Magaluf", "Prestwick", LocalDateTime.now());
        flight2 = new Flight(pilot, crew2, weePlane, "XYZ69", "Bonkle", "Aberdeen", LocalDateTime.now());

    }

    @Test
    public void canGetAvailableSeats(){
        assertEquals(2, flight2.seatAvailability());
    }

    @Test
    public void canBookSeat(){
        flight2.bookSeat(pass2);
        flight2.bookSeat(pass3);
        assertEquals(0, flight2.seatAvailability());
        assertEquals(1, pass2.getSeatNo());
        assertEquals("XYZ69", pass2.getFlight());
    }

    @Test
    public void cantOverBook(){
        flight2.bookSeat(pass1);
        flight2.bookSeat(pass2);
        flight2.bookSeat(pass3);
        assertEquals(4, flight2.numOfBookedSeats());
    }

    @Test
    public void canCalculateCrewBaggage(){
        assertEquals(1.75, flight2.crewBaggageWeight(), 0);
    }

    @Test
    public void canDeductWeight(){
        flight2.bookSeat(pass1);
        assertEquals(0.875, flight2.calculateRemainingBaggageAllowance(), 0);
    }

    @Test
    public void canAssignSeatNo(){
        pass1.setSeatNo(1);
        assertEquals(1, pass1.getSeatNo());
    }

    @Test
    public void canAssignFlight(){
        pass1.setFlight(flight1.getFlightNo());
        assertEquals("XXX420", pass1.getFlight());
    }
}
