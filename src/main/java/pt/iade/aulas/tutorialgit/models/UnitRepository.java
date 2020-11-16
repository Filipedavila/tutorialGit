package pt.iade.aulas.tutorialgit.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UnitRepository {

    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static ArrayList<Unit> getAllUnits() {
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

    public static Unit createUnit(int id) {
        Unit res = null;
        for (Unit inst : units) {
            if (inst.getId() == id) {
                res = inst;
            }

        }
        return res;
    }

    public static Boolean removeStudent(int num) {

        if (StudentRepository.removeStudent(num))
            return true;

        return false;
    }


    public static void addStudent(Student student,Enrolment enroll, int id) {
        for (Unit inst : units) {
            if (inst.getId() == id) {
                inst.addStudent(student);


            }

        }
    }
}