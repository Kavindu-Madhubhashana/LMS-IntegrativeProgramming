package lk.ac.kln.lms.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcements")
@Getter
@Setter
@Data
@NoArgsConstructor @AllArgsConstructor
public class Announcements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "date")
    private Date date;

    @Column(name = "announcement")
    private String announcement;


}


