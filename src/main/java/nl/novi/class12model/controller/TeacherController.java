package nl.novi.class12model.controller;
import nl.novi.class12model.model.Teacher;
import nl.novi.class12model.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository repos;

    public TeacherController(TeacherRepository repos) {
        this.repos = repos;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Teacher>> search(@RequestBody String searchterm) {
        return ResponseEntity.ok(repos.findByLastNameContainingIgnoreCase(searchterm));
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        this.repos.save(teacher);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + teacher.getId()).toUriString());
        return ResponseEntity.created(null).body(teacher);
    }
}
