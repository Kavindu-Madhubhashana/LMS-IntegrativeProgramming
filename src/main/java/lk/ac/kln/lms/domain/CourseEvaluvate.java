package lk.ac.kln.lms.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEvaluvate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
