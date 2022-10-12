package lk.ac.kln.lms.dto;
import lk.ac.kln.lms.domain.CourseEvaluate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface CourseEvaluateDto extends CrudRepository<CourseEvaluate, MyKey> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_course SET marks = :marks WHERE  user_email = :userEmail AND course_id = :courseId", nativeQuery = true)
    Integer addMarks(String userEmail, String courseId, String marks);

    @Query(value = "SELECT * FROM jwt_demo.user_course WHERE user_email = :userEmail", nativeQuery = true)
    List<CourseEvaluate> getMarks(String userEmail);

    @Query(value = "SELECT * FROM jwt_demo.user_course WHERE course_id = :courseId", nativeQuery = true)
    List<CourseEvaluate> getSubjects(String courseId);
}
