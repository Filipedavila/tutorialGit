package pt.iade.aulas.tutorialgit.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {

    private static int nextNumber = 0;
    private int mecNumber;

    private ArrayList<Unit> units;

    public Teacher(String name,  LocalDate birthDay,char gender) {
        super(name,gender,birthDay);
        this.mecNumber = nextNumber;
        nextNumber++;
        units = new ArrayList<Unit>();
    }

    public static int getNextNumber() {

        return nextNumber;
    }

    public ArrayList<Unit> getUnits() {

        return units;
    }

    public void setUnits(ArrayList<Unit> units) {

        this.units = units;
    }



    public static void setNextNumber(int nextNumber) {
        Teacher.nextNumber = nextNumber;
    }

    public int getMecNumber() {

        return mecNumber;
    }

    public void setMecNumber(int mecNumber) {

        this.mecNumber = mecNumber;
    }
    @Override
    public String getName(){
        return "Professor " + name;
    }
    @Override
    public String getReference() {

        return "T<" + mecNumber + ">";
    }
    @Override
    public String toString(){
        return "" + mecNumber + ":" + super.getName();
    }
}
