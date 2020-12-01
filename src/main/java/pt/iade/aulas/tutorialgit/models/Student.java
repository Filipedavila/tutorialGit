package pt.iade.aulas.tutorialgit.models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student extends Person implements  Statistical{
 private static int nextNumber = 0;
 private int number;

 @JsonIgnore
 private  ArrayList<Unit> units;
    @JsonIgnore
 private ArrayList<Enrolment> enrolments;

    public Student(String name, LocalDate birthDay, char gender) {
        super(name, gender, birthDay);
        this.number = nextNumber;
        nextNumber++;
        email = "";

        units = new ArrayList<Unit>();
        enrolments = new ArrayList<>();
    }
    public static int getNextNumber() {
        
        return nextNumber; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) {
          this.name = name; 
        }

    public LocalDate getBirthDate() {
        return birthDay;
    }

    public static void setNextNumber(int nextNumber) {
        Student.nextNumber = nextNumber;
    }

    public void setBirthDate(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
		this.number = number;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public  Enrolment getEnrolmentUnitById(int unitId){
        Enrolment enroll = null;
        for(Enrolment enr:enrolments)
            if(enr.getUnit().getId()==unitId)
                enroll = enr;


            return enroll;

    }
    public void inscribe(int id){
       Unit uni = UnitRepository.getUnit(id);

       units.add(uni);
       Enrolment enroll = new Enrolment(this,uni,0);
       enrolments.add(enroll);
       UnitRepository.addStudent(this,enroll,id);
    }

    public  ArrayList<Enrolment> getEnrolments() {

        return enrolments;
    }

    public Response enroll(Enrolment enrolmentToAdd) {
        for(Enrolment enrolmentStudent: enrolments){
            if(enrolmentStudent.getUnit() == enrolmentToAdd.getUnit() ){
                return (new Response("Já existe o enrollment", null));
            }
        }
        enrolments.add(enrolmentToAdd);
        enrolmentToAdd.getUnit().getEnrolments().add(enrolmentToAdd);

        return (new Response("Foi adicionado com sucesso", enrolmentToAdd));
        // TO DO atualizar tambem a lista nos units

    }

    public double getUnitGradeByID(int id){
       double grade = 0;
        for ( Enrolment enrolls : enrolments ) {
            if(enrolls.getUnit().getId() == id) grade = enrolls.getGrade();
        }

        return grade;
    }

    @Override
    public String getReference() {

        return "S<"+number+">";
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

    public double getGrade(Unit unit){
       return getEnrolmentUnitById(unit.getId()).getGrade();
    }

    @Override
    public HistogramSlot[] getHistogram(Integer nSlots) {
   // for(int i =0; i< nSlots; i++){


    //}
        return null;
    }
}