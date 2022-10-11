package lk.ac.kln.lms.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentDto {

    private String name;

    private String email;

    private String password;

    private String studentId;

    private Date birthDate;

    private String phoneNumber;

}
