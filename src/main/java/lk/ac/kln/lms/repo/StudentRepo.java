package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    Optional<Student> findByStudentId(final String studentId);

}
