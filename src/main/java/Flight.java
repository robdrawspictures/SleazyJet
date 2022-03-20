import people.crew.CabinCrew;
import people.crew.Pilot;
import people.passenger.Passenger;

import java.util.ArrayList;

public class Flight {

    private Pilot pilot;
    private ArrayList<CabinCrew> cabinCrew;
    private ArrayList<Passenger> passengerManifest;
    private Plane plane;
    private String flightNo;
    private String destination;
    private String departure;
    private String depTime;

    public Flight(Pilot pilot, ArrayList<CabinCrew> cabinCrew, Plane plane, String flightNo, String destination, String departure, String depTime) {
        this.pilot = pilot;
        this.cabinCrew = cabinCrew;
        this.passengerManifest = new ArrayList<>();
        this.plane = plane;
        this.flightNo = flightNo;
        this.destination = destination;
        this.departure = departure;
        this.depTime = depTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public ArrayList<CabinCrew> getCabinCrew() {
        return cabinCrew;
    }

    public ArrayList<Passenger> getPassengerManifest() {
        return passengerManifest;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDepTime() {
        return depTime;
    }

    public int getCrewSize(){
        return cabinCrew.size();
    }

    public int getPassengerCount(){
        return passengerManifest.size();
    }

    public int numOfBookedSeats(){
        return 1 + this.cabinCrew.size() + this.passengerManifest.size();
    }

    public int seatAvailability(){
        return this.plane.planeType.returnCapacity() - (1 + this.cabinCrew.size() + this.passengerManifest.size());
    }

    public void bookSeat(Passenger newBooking){
        if(numOfBookedSeats() < this.plane.planeType.returnCapacity()) {
            this.passengerManifest.add(newBooking);
        }
    }

    public double crewBaggageWeight(){
        double individualAllowance = this.plane.calculateIndividualBagAllowance();
        int totalCrew = 1 + getCrewSize();
        double crewBaggageWeight = individualAllowance * totalCrew;
        return crewBaggageWeight;
    }

    public double passengerBaggageWeight(){
        double passengerBaggageWeight = this.plane.calculateIndividualBagAllowance() * getPassengerCount();
        return passengerBaggageWeight;
    }

    public double calculateRemainingBaggageAllowance(){
        double crewBag = crewBaggageWeight();
        double passBag = passengerBaggageWeight();
        double totalConsumedWeight = crewBag + passBag;
        return this.plane.calculateBaggageAllowance() - totalConsumedWeight;
    }
}
