package pt.iade.aulas.tutorialgit.models;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class UnitRepository {

    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static ArrayList<Unit> getAllUnits() {
        return units;
    }

    public static void populate() {

        units.add(new Unit(1,"POO", 6));
        units.add(new Unit(2,"DB", 6));
        units.add(new Unit(3,"TIC", 6));
        units.add(new Unit(4,"TIC2", 6));
    }

    public static ArrayList<Unit> getUnits() {
    return units;

    }
    public static Unit getUnit(int id) {
        Unit res = null;
        for (Unit inst : units) {
            if (inst.getId() == id) {
                res = inst;
            }

        }
        return res;
    }


    /**
     *
     * @param unit
     * @requires That is checked wether already exists
     * @return
     */
    public static Unit createUnit(Unit unit) {
     units.add(unit);


        return unit;
    }


    public static Boolean removeStudent(int num) {

        if (StudentRepository.removeStudent(num))
            return true;

        return false;
    }

    public static void addStudentToList(Student std){

    }

    public static void addStudent(Student student,Enrolment enroll, int id) {   // verificar se o Enrolment já não existe   2. verificar onde está a ser adicionado
        addStudentToList(student);
        for (Unit inst : units) {
            if (inst.getId() == enroll.getUnit().getId()) {   // se encontrar id pertencende  À unidade

                student.enroll(enroll);
                inst.addStudent(student);
                inst.addEnrolment(enroll);


            }

        }
    }



}