package pt.iade.aulas.tutorialgit.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void getAverage() {
    }

    @Test
    void getMax() {
    }

    @Test
    void getMin() {
    }

    @Test
    void getHistogram() {
        UnitRepository.populate();
        StudentRepository.populate();
        TeacherRepository.populate();
        Unit Poo = UnitRepository.getUnit(1);
        System.out.println(Poo.getName());
        Student st1 = StudentRepository.getStudent(1);
        st1.inscribe(1);
        Enrolment novo =new Enrolment(st1, Poo , 15);
        st1.enroll(novo);
        st1.getEnrolmentUnitById(1).setGrade(10);
        UnitRepository.addStudent(st1, novo, 1 );

        Student st2 = StudentRepository.getStudent(2);

        st2.inscribe(1);
        st2.enroll(new Enrolment(st2, Poo , 10));
        Poo.addStudent(st2);

        System.out.println(Poo.getMin());
    }
}