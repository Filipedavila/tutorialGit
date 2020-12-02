package pt.iade.aulas.tutorialgit.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Teacher extends Person implements  Statistical{

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

    @Override
    public double getAverage() {
        Double soma = units.stream().mapToDouble(x -> x.getAverage()).sum();

        return Math.round(soma / units.size());
    }

    @Override
    public double getMax() {

        Optional<Unit> max = units.stream().reduce((acc, x) -> acc.getMax() <= x.getMax() ? x : acc);

        return max.get().getMax();
    }

    @Override
    public double getMin() {
        Optional<Unit> min = units.stream().reduce((acc, x) -> acc.getMin() >= x.getMin() ? x : acc);

        return min.get().getMin();
    }

    @Override
    public HistogramSlot[] getHistogram(Integer nSlots) {
        return new HistogramSlot[0];
    }
}
