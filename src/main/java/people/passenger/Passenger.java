package people.passenger;

import people.Person;

public class Passenger extends Person {

    private Integer bags;

    public Passenger(String name, Integer bags) {
        super(name);
        this.bags = bags;
    }

    public Integer getBags() {
        return bags;
    }
}
