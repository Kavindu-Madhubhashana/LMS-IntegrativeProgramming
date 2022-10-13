package lk.ac.kln.lms.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewEnrollmentDto {

    private Date enrollmentDate;

    private Boolean cancelled;

    private String cancellationReason;

    private Long studentId;

    private Long courseId;

}
