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
}