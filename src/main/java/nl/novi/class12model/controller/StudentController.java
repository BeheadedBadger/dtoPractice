package nl.novi.class12model.controller;

import nl.novi.class12model.model.Student;
import nl.novi.class12model.model.Teacher;
import nl.novi.class12model.repository.StudentRepository;
import nl.novi.class12model.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repos;

    public StudentController(StudentRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {
        this.repos.save(student);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + student.getStudentNr()).toUriString());
        return ResponseEntity.created(uri).body(student);
    }
}
