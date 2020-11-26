package pt.iade.aulas.tutorialgit.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeacherRepository {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
        Teacher t; // auxiliary variable
        t = new Teacher("Tiago", LocalDate.parse("2000-10-24"),'M');
        t.setEmail("johTeachern@gmail.com");
        teachers.add(t);
        teachers.add(new Teacher("Maria",LocalDate.parse("1999-12-23"),'F'));
        t = new Teacher("James",LocalDate.parse("2001-07-02"),'M');
        teachers.add(t);
    }

    public static Teacher getTeacher(int num){
        Teacher res = null;
        for(Teacher inst : teachers){
            if(inst.getMecNumber()== num){
                res= inst;
            }

        }
        return res;
    }




    public static Teacher addTeacher(Teacher add){

        teachers.add(add);
        return add;
    }
    public static List<Unit> addUnit(int unitId, int id){

        Teacher res = getTeacher(id);
        res.getUnits().add(UnitRepository.getUnit(unitId));
        return res.getUnits();
    }
    public static Response removeUnit(int unitId, int teacheId){
        boolean state = false;
        Response  resp = new Response("Failed", null);
        Teacher teacher = getTeacher(teacheId);
        teacher.getUnits().forEach((x) ->{ if( x.getId() == unitId){
            teacher.getUnits().remove(x) ;
            resp.setMessage("Success");
            resp.setObject(teacher);}});
      return  resp;
    }
    public static ArrayList<Teacher>  getTeachers() {

        return teachers;
    }
}
