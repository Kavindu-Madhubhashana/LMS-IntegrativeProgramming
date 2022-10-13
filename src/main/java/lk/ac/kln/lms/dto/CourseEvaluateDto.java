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
    @Query(value = "UPDATE user_evaluate SET marks = :marks WHERE  student_id = :studentID AND course_id = :courseId", nativeQuery = true)
    Integer addMarks(String studentID, String courseId, String marks);

    @Query(value = "SELECT * FROM jwt_demo.user_evaluate WHERE student_id = :studentID", nativeQuery = true)
    List<CourseEvaluate> getMarks(String studentID);
        //StudentEmail
    @Query(value = "SELECT * FROM jwt_demo.user_evaluate WHERE student_id = :studentID", nativeQuery = true)
    List<CourseEvaluate> getSubjects(String courseId);
}
