package lk.ac.kln.lms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser student;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
}
