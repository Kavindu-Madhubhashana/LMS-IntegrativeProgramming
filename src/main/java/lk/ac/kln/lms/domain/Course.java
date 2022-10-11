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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String courseCode;

    @Column(name = "name")
    private String courseName;

    private String description;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private CourseCategory courseCategory;
}
