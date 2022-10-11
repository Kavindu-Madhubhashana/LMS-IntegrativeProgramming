package lk.ac.kln.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCourseDto {

    private Long courseId;

    private String courseCode;

    private String courseName;

    private String description;

    private Date startDate;

    private Date endDate;

    private Long courseCategoryId;
}
