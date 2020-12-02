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
        Enrolment novo =new Enrolment(st1, Poo , 1);
        UnitRepository.addStudent(st1, novo , 1);



        Student st2 = StudentRepository.getStudent(2);
        Enrolment novo2 =new Enrolment(st2, Poo , 10);
        UnitRepository.addStudent(st2, novo2 , 1);

        Student st3 = StudentRepository.getStudent(3 );

        UnitRepository.addStudent(st3, new Enrolment(st3, Poo, 3)  , 1);
        Unit SO = UnitRepository.getUnit(3);

        Enrolment novo22 =new Enrolment(st1, SO , 20);
        UnitRepository.addStudent(st1, novo, 1);
        UnitRepository.addStudent(st1, novo22 , 1);



        HistogramSlot[] teste = Poo.getHistogram(20);

        for(int i=0; i< 20;i++){
            System.out.println(teste[i].toString());
        }
    }
}