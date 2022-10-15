package lk.ac.kln.lms.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter


//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String grade;

    @OneToOne(fetch = FetchType.EAGER)
    private Course course;


}


