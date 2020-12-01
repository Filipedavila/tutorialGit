package pt.iade.aulas.tutorialgit.models;

public class Material {
    private static int nextNumber = 0;
    protected  int id;
    protected String name;
    protected MaterialState state;



    public Material(String name) {
        this.id = nextNumber;
        nextNumber++;
        this.id = id;
        this.name = name;
        this.state = MaterialState.OK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialState getState() {
        return state;
    }

    public void setState(MaterialState state) {
        this.state = state;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
