package pt.iade.aulas.tutorialgit.controllers;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.Student;
import pt.iade.aulas.tutorialgit.models.StudentRepository;
import pt.iade.aulas.tutorialgit.models.Response;
import pt.iade.aulas.tutorialgit.models.exeptions.NotFoundException;


@RestController
    @RequestMapping(path="/api/student/")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping(path = "/populate/", produces= MediaType.APPLICATION_JSON_VALUE)
    public void populate() {

        logger.info("Populating");
        StudentRepository.populate();



    }

    @GetMapping(path = "/get/", produces= MediaType.APPLICATION_JSON_VALUE)
     public List<Student> getStudents() {

            logger.info("Sending all students");
            return StudentRepository.getAllStudents();
    }

    @GetMapping(path = "/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
        public Student getStudent(@PathVariable("number") int number) throws NotFoundException {
            logger.info("Sending student with number "+number);
            Student student = StudentRepository.getStudent(number);
            if (student != null) return student;
            else throw new NotFoundException("" + String.valueOf(number), "Student", "number");
    }
    @DeleteMapping(path = "/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number) {
        logger.info("deleting student with number "+number);

        if (StudentRepository.removeStudent(number))

            return new Response(number + " was deleted.", null) {
            };

        else 
            return new Response(number+" not found.",null);
    }
    @PostMapping(path = "/add/",    produces= MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {

        StudentRepository.addStudent(student);
        return student;
    
    }
   
}
