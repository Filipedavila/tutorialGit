package pt.iade.aulas.tutorialgit.models;

import java.util.ArrayList;

public class GroupResult {

    int size ;
    double average;
    Object objecto;

    public GroupResult(int size, double average, Object objeto) {
        this.size = size;
        this.average = average;
        this.objecto = objeto;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
