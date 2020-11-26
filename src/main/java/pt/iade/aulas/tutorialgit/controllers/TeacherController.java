package pt.iade.aulas.tutorialgit.controllers;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.*;
import pt.iade.aulas.tutorialgit.models.exeptions.AlreadyExistsException;
import pt.iade.aulas.tutorialgit.models.exeptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/teachers/")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Teacher> getTeachers() {
        logger.info("Sending all Teachers");
        return TeacherRepository.getTeachers();

    }

    @GetMapping(path = "/{mecNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacher(@PathVariable int mecNumber) throws NotFoundException{
        logger.info("Sending teacher with mec number" + mecNumber );
       Teacher teacher =TeacherRepository.getTeacher(mecNumber);
       if (teacher !=null){
           return teacher;
       }else{
           throw new NotFoundException(" Npt found" , "Teacher with id " , mecNumber +" ");
       }

    }
    @GetMapping(path = "/{mecNum}/units/", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ArrayList<Unit> getUnitsByTeacher(@PathVariable int mecNum) throws NotFoundException{
        logger.info("Sending Units of teacher with mec number" + mecNum );
        ArrayList<Unit> units = getTeacher(mecNum).getUnits();
        if(units == null ){
            throw new NotFoundException(" Npt found" , "Units from Teacher with id " , mecNum +" ");}
        else {
            return units;
        }

    }
    @GetMapping (path = "/{id}/units/add/{unit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addUnit(@PathVariable int unit, @PathVariable int id) {
        logger.info("Adding Unit to teacher with id " + id );
        List<Unit> res =  TeacherRepository.addUnit(unit, id);
        if(res == null){
            return (new Response( "Failed ",null));
        }else{
            return (new Response( "Suceess ",res ));
        }

    }
    @DeleteMapping (path = "/{id}/units/del/{unit}")
    public Response removeUnit(@PathVariable int unit, @PathVariable int id) {
        logger.info("Removing unit with id" + unit + " from teacher with id" + id );
        TeacherRepository.removeUnit(unit,id);
        return TeacherRepository.removeUnit(unit,id);
    }




}
