package pt.iade.aulas.tutorialgit.controllers;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path="/api/persons/")

public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getAllStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }

    @GetMapping(path = "/search/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person searchPersons(@RequestParam(value = "ref", defaultValue = "") String ref) {
        logger.info("Searching for person with reference" + ref);
        char refChar = Character.toUpperCase(ref.charAt(0));
        Person person = null;
        if (refChar == 'T') {
            List<Teacher> teachers = TeacherRepository.getTeachers();

            for (Teacher teacher : teachers) {
                if (teacher.getReference().equals(ref)) return teacher;
            }


        } else if (refChar == 'S') {

            List<Student> students = StudentRepository.getAllStudents();

            for (Student stud : students) {
                if (stud.getReference().equals(ref)) return stud;
            }


        }

        return person;
    }


        @GetMapping(path = "/search",  produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Person> searchPersons (
                @RequestParam(value = "name", defaultValue = "") String name,
                @RequestParam(value = "email", defaultValue = "") String email){
            logger.info("Searching for person with the atribute " +name +" " + email);
            ArrayList<Person> persons = new ArrayList<>();
            persons.addAll(StudentRepository.getAllStudents());
            persons.addAll(TeacherRepository.getTeachers());
            persons.removeIf(
                    (p) -> !(p.getName().contains(name) &&
                            p.getEmail().contains(email)));
            return persons;
        }
    }

