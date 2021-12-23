package G5.G5.student;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Table(name = "student")
@Entity
public class Student {

    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student(){
    }

    public Student(String name,
                   String email,
                   LocalDate dob,
                   Integer age){
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.age=age;
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob,
                   Integer age){
        this.id=id;
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.age=age;
    }


}
