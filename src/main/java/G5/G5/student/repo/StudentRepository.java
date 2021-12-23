package G5.G5.student.repo;

import G5.G5.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fuhao_Pan
 * @date 12/23/2021
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
