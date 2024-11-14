package rocking_villains;

import java.io.Serializable;

public class LeadVillain implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String occupation;
    private String backstory;

    public LeadVillain(String name, String occupation, String backstory) {
        this.name = name;
        this.occupation = occupation;
        this.backstory = backstory;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getBackstory() {
        return backstory;
    }
}
