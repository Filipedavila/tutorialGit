package pt.iade.aulas.tutorialgit.models;

import java.util.ArrayList;
import java.util.List;

public class Laboratory extends  Room{
    protected List<Material> material;


    public Laboratory(String designation, Integer capacity) {
        super(designation, capacity);
        this.material = new ArrayList<Material>();
    }
}
