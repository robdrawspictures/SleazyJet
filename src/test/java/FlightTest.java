import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrew;
import people.crew.CrewType;
import people.crew.Pilot;
import people.passenger.Passenger;

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
        bigPlane = new Plane(PlaneType.BOEING747, PlaneType.BOEING747.returnCapacity());
        weePlane = new Plane(PlaneType.CESSNA172, PlaneType.BOEING747.returnCapacity());
        flight1 = new Flight(pilot, crew1, passengerRoster1, bigPlane, "XXX420", "Magaluf", "Prestwick", "1600 HOURS");
        flight2 = new Flight(pilot, crew2, passengerRoster2, weePlane, "XYZ69", "Bonkle", "Aberdeen", "2300 HOURS");

    }

    @Test
    public void canGetAvailableSeats(){
        assertEquals(1, flight2.seatAvailability());
    }

    @Test
    public void canBookSeat(){
        flight2.bookSeat(pass2);
        assertEquals(0, flight2.seatAvailability());
    }

    @Test
    public void cantOverBook(){
        flight2.bookSeat(pass2);
        flight2.bookSeat(pass3);
        assertEquals(4, flight2.numOfBookedSeats());
    }
}
