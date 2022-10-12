package lk.ac.kln.lms.domain;
import javax.persistence.*;
import lk.ac.kln.lms.dto.MyKey;

@Entity(name = "courseEvaluate")
@IdClass(MyKey.class)

public class CourseEvaluate {
    @Id
    @Column(length = 20)
    private String userID;

    @Id
    @Column(length = 10)
    private String courseId;

    private String marks;

    public String getUserEmail() {
        return userID;
    }

    public void setUserEmail(String userID) {
        this.userID = userID;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

}