package pt.iade.aulas.tutorialgit.models;

public class Room {
    protected String designation;
    protected  Integer capacity;


    public Room(String designation , Integer capacity){
        this.designation = designation;
        this.capacity = capacity;
    }
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


}
