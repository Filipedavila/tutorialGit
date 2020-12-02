package pt.iade.aulas.tutorialgit.models;

public class Enrolment {
    private Student student;
    private Unit unit;
    private double grade;

    public Enrolment(Student student, Unit unit, double grade) {
        this.student = student;
        this.unit = unit;
        this.grade = grade;
    }



    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Unit getUnit() {
        return unit;
    }

    public Student getStudent() {
        return student;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("[");
        build.append(" ");
        build.append(this.getStudent().getName());
        build.append("- Grade : ");
        build.append(this.getGrade());
        build.append("]");
        return build.toString();
    }
}
