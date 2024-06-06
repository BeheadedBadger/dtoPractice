package nl.novi.class12model.model;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private int studentNr;
    private String firstName;
    private String lastName;
    private Date startdate;

    public int getStudentNr() {
        return studentNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
}
