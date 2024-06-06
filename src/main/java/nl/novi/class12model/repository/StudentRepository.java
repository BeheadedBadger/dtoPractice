package nl.novi.class12model.repository;
import nl.novi.class12model.model.Student;
import nl.novi.class12model.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
