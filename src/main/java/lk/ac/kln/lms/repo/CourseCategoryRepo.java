package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.CourseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseCategoryRepo extends CrudRepository<CourseCategory, Long> {

    Optional<CourseCategory> findByName(String categoryName);

    //Get ALL
    // GEtById
    //Save

}
