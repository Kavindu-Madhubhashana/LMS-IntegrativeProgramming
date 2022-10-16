package lk.ac.kln.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementsDto {
    private Date date;
    private String announcement;
    private Long userId;
    private String courseCode;
}
