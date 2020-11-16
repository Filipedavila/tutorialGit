package pt.iade.aulas.tutorialgit.controllers;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.*;
import pt.iade.aulas.tutorialgit.models.exeptions.AlreadyExistsException;
import pt.iade.aulas.tutorialgit.models.exeptions.NotFoundException;


@RestController
    @RequestMapping(path="/api/students")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping(path = "/{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Enrolment> getEnrolments(@PathVariable("number") int number) throws NotFoundException {
        logger.info("Sending enrolments of student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) return student.getEnrolments();
        else throw new NotFoundException("" + number, "Student", "number");
    }

    @GetMapping(path = "{number}/enrolments/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment getEnrolment(@PathVariable("number") int number, @PathVariable("unitId") int unitId)
            throws NotFoundException {
        logger.info("Sending enrolment with id " + unitId +
                " of student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Enrolment enr = student.getEnrolmentUnitById(unitId);
            if (enr != null) return enr;
            else throw new NotFoundException("" + unitId, "Unit", "id");
        } else throw new NotFoundException("" + number, "Student", "number");
    }

    @PutMapping(path = "{number}/enrolments/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment setGrade(@PathVariable("number") int number,
                              @PathVariable("unitId") int unitId,
                              @RequestBody double grade)     throws NotFoundException {
        logger.info("Setting grade of enrolment with id " + unitId +
                " of student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Enrolment enr = student.getEnrolmentUnitById(unitId);
            if (enr != null) {
                enr.setGrade(grade);
                return enr;
            } else throw new NotFoundException("" + unitId, "Unit", "id");
        }
        return null;

    }


    @PostMapping(path = "{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment addEnrolment(@PathVariable("number") int number, @RequestBody int unitId) throws NotFoundException, AlreadyExistsException {
        logger.info("Enroling student with number " +
                number + " in unit with id " + unitId);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Unit unit = UnitRepository.getUnit(unitId);
            if (unit != null) {
                if (student.getEnrolmentUnitById(unitId) != null)
                    throw new AlreadyExistsException("Erro ",""+unitId, "Já existe este enrolment");
                else {
                    Enrolment enrolment = new Enrolment(student, unit, -1);
                    student.enroll(enrolment);
                    return enrolment;
                }
            } else throw new NotFoundException("" + unitId, "Unit", "id");
        } else throw new NotFoundException("" + number, "Student", "number");
    }
}