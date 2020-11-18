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

public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents());
        persons.addAll(TeacherRepository.getTeachers());

    }
    @GetMapping(path = "/search",
            produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> searchPersons(
            @RequestParam(value = "name",defaultValue="") String name,
            @RequestParam(value = "email",defaultValue="") String email) {
        ArrayList<Person> persons = getAllPersons();
        persons.removeIf(
                (p) -> !(p.getName().contains(name) &&
                        p.getEmail().contains(email)));
        r
}
