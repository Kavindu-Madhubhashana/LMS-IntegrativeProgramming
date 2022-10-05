package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.CourseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CourseCategoryRepo extends CrudRepository<CourseCategory, Long> {

    Optional<CourseCategory> findByCourseCategory(String courseCategory);

}
