package lk.ac.kln.lms.domain;

import lk.ac.kln.lms.enums.GradeEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser teacher;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser student;

    @OneToOne(fetch = FetchType.EAGER)
    private Course course;

    private GradeEnum grade;

}
