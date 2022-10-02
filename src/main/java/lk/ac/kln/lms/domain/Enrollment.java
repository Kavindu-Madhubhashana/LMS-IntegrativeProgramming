package lk.ac.kln.lms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
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
}
