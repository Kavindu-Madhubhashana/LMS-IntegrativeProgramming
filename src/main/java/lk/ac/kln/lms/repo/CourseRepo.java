package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    Optional<Course> findByCourseCode(final String code);
}
