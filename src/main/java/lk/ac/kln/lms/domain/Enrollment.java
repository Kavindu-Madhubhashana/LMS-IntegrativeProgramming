package lk.ac.kln.lms.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date enrollmentDate;

    private Boolean cancelled;

    private String cancellationReason;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
