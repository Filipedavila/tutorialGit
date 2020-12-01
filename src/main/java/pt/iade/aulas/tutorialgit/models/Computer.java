package pt.iade.aulas.tutorialgit.models;

public class Computer extends Material{

    String specifications;

    public Computer(String name, String specifications) {
        super(name);
        this.specifications = specifications;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
