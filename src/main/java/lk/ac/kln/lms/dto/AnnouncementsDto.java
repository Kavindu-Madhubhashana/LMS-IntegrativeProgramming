package lk.ac.kln.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class AnnouncementsDto {
    private long id;
    private Date date;
    private String announcement;
    private Long lecturerId;
    private Long courseCode;
}
