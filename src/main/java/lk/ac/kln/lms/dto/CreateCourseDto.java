package lk.ac.kln.lms.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CreateCourseDto {

    private String courseCode;

    private String courseName;

    private String description;

    private Date startDate;

    private Date endDate;

}
