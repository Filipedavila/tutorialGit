package pt.iade.aulas.tutorialgit.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Unit implements Statistical {
    private int id;
    private String name;
    private int credits;
    @JsonIgnore
    private ArrayList<Student> students;
    @JsonIgnore
    private  ArrayList<Enrolment> enrolments;

    public Unit(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.students = new ArrayList<Student>();
        this.enrolments = new ArrayList<Enrolment>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getCredits() {

        return credits;
    }

    public void setCredits(int credits) {

        this.credits = credits;
    }

    public ArrayList<Student> getStudents() {

        return students;
    }

    public void setStudents(ArrayList<Student> students) {

        this.students = students;
    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public ArrayList<Enrolment> getEnrolments() {

        return enrolments;
    }

    public void addEnrolment(Enrolment enroll)
    {

        this.enrolments.add(enroll);
    }

    @Override
    public double getAverage() {
        Double soma = enrolments.stream().mapToDouble(x -> x.getGrade()).sum();

        return Math.round(soma/ enrolments.size());
    }

    @Override
    public double getMax() {
        Optional<Enrolment> max = enrolments.stream().reduce((acc , x ) ->acc.getGrade() <= x.getGrade() ? x : acc);
        return max.get().getGrade();

    }
    @Override
    public double getMin() {
        Optional<Enrolment>  min = enrolments.stream().reduce((acc , x ) ->acc.getGrade() >= x.getGrade() ? x : acc);

        return min.get().getGrade();
    }

    @Override
    public HistogramSlot[] getHistogram(Integer nSlots) {
        double iter = 20 / nSlots;
        HistogramSlot[] history = new HistogramSlot[nSlots];
        for( int i = 0, j = 0; i <= nSlots; i+= iter, j++) {
            double start = i;
            double End = i + iter;
            long Hmany = students.stream().filter((x)->  x.getGrade(this) > start && x.getGrade(this) <= End).count();
            history[j]  = new HistogramSlot( i , i + i, (int) Hmany);
        }
        return history;
    }
}
