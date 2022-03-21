package people.passenger;

import people.Person;

public class Passenger extends Person {

    private Integer bags;
    private Integer seatNo;
    private String flight;

    public Passenger(String name, Integer bags) {
        super(name);
        this.bags = bags;
        this.seatNo = null;
        this.flight = null;
    }

    public int getBags() {
        return bags;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public String getFlight(){
        return flight;
    }

    public void setFlight(String flight){
        this.flight = flight;
    }

    public void setSeatNo(int seat){
        this.seatNo = seat;
    }
}
