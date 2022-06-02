package org.launchcode.techjobs.oo;

import java.util.HashMap;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        //Job job3 = new Job();
        //Job job2 = new Job(null, null, null, new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String parsedName = ("".equals(this.getName()) || this.getName() == null) ?  "Data not available" : this.getName();
        String parsedEmployer = ("".equals(this.getEmployer()) || this.getEmployer() == null) ?  "Data not available" : this.getEmployer().toString();
        String parsedLocation = ("".equals(this.getLocation()) || this.getLocation() == null) ?  "Data not available" : this.getLocation().toString();
        String parsedPositionType = ("".equals(this.getPositionType()) || this.getPositionType() == null) ?  "Data not available" : this.getPositionType().toString();
        String parsedCoreCompetency = ("".equals(this.getCoreCompetency()) || this.getCoreCompetency() == null) ?  "Data not available" : this.getCoreCompetency().toString();

        if (this.getName()==null && this.getEmployer()==null && this.getLocation()==null && this.getPositionType()==null && this.getCoreCompetency()==null) {
            return "OOPS! This job does not seem to exist.";
        }

        return "\n" +
                "ID: " + this.getId()+
                "\nName: " + parsedName+
                "\nEmployer: " + parsedEmployer+
                "\nLocation: " + parsedLocation+
                "\nPosition Type: " + parsedPositionType+
                "\nCore Competency: " + parsedCoreCompetency+
                "\n";
    }

}
