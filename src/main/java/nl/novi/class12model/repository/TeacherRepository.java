package nl.novi.class12model.repository;
import nl.novi.class12model.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
List<Teacher> findByLastNameContainingIgnoreCase (String string);

}
