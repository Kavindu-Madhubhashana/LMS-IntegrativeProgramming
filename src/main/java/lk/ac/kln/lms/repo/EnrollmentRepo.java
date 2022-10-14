package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.Enrollment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends CrudRepository<Enrollment, Long> {
}
