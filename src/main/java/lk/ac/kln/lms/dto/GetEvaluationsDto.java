package lk.ac.kln.lms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEvaluationsDto {

    private Long studentId;
    private Long lectuerId;

}
