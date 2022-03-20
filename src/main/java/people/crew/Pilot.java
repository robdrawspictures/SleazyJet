package people.crew;

import people.Person;

public class Pilot extends Person {

    private CrewType crewType;
    private String licence;

    public Pilot(String name, CrewType crewType, String licence) {
        super(name);
        this.crewType = crewType;
        this.licence = licence;
    }

    public CrewType getCrewType() {
        return crewType;
    }

    public String getLicence() {
        return licence;
    }

    public String chocksAway(){
        return "I feel the need. The need for speed.";
    }
}
