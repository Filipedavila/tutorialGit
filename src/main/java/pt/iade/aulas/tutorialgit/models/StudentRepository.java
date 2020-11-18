package pt.iade.aulas.tutorialgit.models;

import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class StudentRepository {
    @JsonIgnore
 private static ArrayList<Student> students = new ArrayList<Student>();
 public static void populate() {
 Student s; // auxiliary variable
 s = new Student("John",LocalDate.parse("2000-05-24"),'M');
 s.setEmail("john@gmail.com");
 students.add(s);
 students.add(new Student("Mary",LocalDate.parse("1999-12-23"),'F'));
 s = new Student("James",LocalDate.parse("2001-07-02"),'M');
 students.add(s);
 }

 public static ArrayList<Student> getAllStudents(){
     return students;
 }

 public static Student getStudent(int num){
    Student res = null;
    for(Student inst : students){
        if(inst.getNumber()== num){
            res= inst;
        }
        
    }
    return res;
 }

 public static Boolean removeStudent(int num){
    Student remove = getStudent(num);
    boolean res = false;
    if(remove != null){
        students.remove(remove);
        res= true;
     }
    return res;
    }
 
 
 public static Student addStudent(Student add){

    students.add(add);
    return add;
 }


    public static Collection<? extends Person> getStudents() {
    }
}