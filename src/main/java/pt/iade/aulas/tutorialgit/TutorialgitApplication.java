package pt.iade.aulas.tutorialgit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.iade.aulas.tutorialgit.models.StudentRepository;

@SpringBootApplication
public class TutorialgitApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialgitApplication.class, args);
		StudentRepository.populate();


	}

}
