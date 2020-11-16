package pt.iade.aulas.tutorialgit.models;

import java.util.ArrayList;

public class Unit {
    private int id;
    private String name;
    private int credits;
    private ArrayList<Student> students;
    private  ArrayList<Enrolment> enrolments;

    public Unit(int id, String name, int credits, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        students = new ArrayList<Student>();
        enrolments = new ArrayList<Enrolment>();
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
}
