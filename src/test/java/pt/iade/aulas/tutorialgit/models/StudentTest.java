package pt.iade.aulas.tutorialgit.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.iade.aulas.tutorialgit.TutorialgitApplication;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {



    @Test
    void getAverage() {
    }

    @Test
    void getMax() {
    }

    @Test
    void getMin() {
        UnitRepository.populate();
        StudentRepository.populate();
        TeacherRepository.populate();
        Unit Poo = UnitRepository.getUnit(1);
        System.out.println(Poo.getName());
        Student st1 = StudentRepository.getStudent(1);
        st1.inscribe(1);
        st1.getEnrolmentUnitById(1).setGrade(1);
        st1.inscribe(2);
        st1.getEnrolmentUnitById(2).setGrade(20);
        st1.inscribe(3);
        st1.getEnrolmentUnitById(3).setGrade(200);
        System.out.println(st1.getMax());

    }

    @Test
    void getHistogram() {
        UnitRepository.populate();
        StudentRepository.populate();
        TeacherRepository.populate();

        Student st1 = StudentRepository.getStudent(1);

        Unit Poo = UnitRepository.getUnit(1);
        Unit DB = UnitRepository.getUnit(2);
        Unit SO = UnitRepository.getUnit(3);
        Unit CC = UnitRepository.getUnit(4);

        Enrolment novo =new Enrolment(st1, Poo , 20);
        UnitRepository.addStudent(st1, novo , 1);
        Enrolment novo2 =new Enrolment(st1, DB , 15);
        UnitRepository.addStudent(st1, novo2 , 2);
        Enrolment novo3 =new Enrolment(st1, SO , 16);

        Enrolment novo4 =new Enrolment(st1, CC , 16);
        UnitRepository.addStudent(st1, novo4 , 4);

        UnitRepository.addStudent(st1, novo3 , 3);



        HistogramSlot[] alone = st1.getHistogram(10);

        for(int i = 0; i< 10 ; i++ ){
            System.out.println(  alone[i].toString());
        }

    }
}