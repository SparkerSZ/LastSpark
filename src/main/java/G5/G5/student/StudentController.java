package G5.G5.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {

    @GetMapping
    @ResponseBody
    public List<Student> getStudents(){
        Student wen = new Student(
                1L,
                "Wu wen",
                "Wen@wu.com",
                LocalDate.of(2021, Month.JANUARY, 5),
                21);

        Student wen2 = new Student(
                1L,
                "Wu wen robot",
                "Wen@wu.com",
                LocalDate.of(2021, Month.JANUARY, 5),
                21);

        Student[] students = {wen,wen2};

        List<Student> list = Arrays.asList(students);
        return list;

    }
}
