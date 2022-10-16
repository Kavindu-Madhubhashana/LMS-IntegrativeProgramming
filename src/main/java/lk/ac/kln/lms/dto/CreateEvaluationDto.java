package lk.ac.kln.lms.dto;

import lk.ac.kln.lms.enums.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEvaluationDto {
    private Long teacherId;

    private Long studentId;

    private Long courseId;

    private GradeEnum grade;
}
