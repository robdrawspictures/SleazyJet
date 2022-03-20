package people.crew;

import people.Person;

public class CabinCrew extends Person {

    private CrewType rank;

    public CabinCrew(String name, CrewType rank) {
        super(name);
        this.rank = rank;
    }

    public CrewType getRank() {
        return rank;
    }

    public String makeAnnouncement(String message){
        return message;
    }
}
