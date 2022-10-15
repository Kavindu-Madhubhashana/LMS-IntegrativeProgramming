package lk.ac.kln.lms.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser lecturer;

   // @ManyToOne(fetch = FetchType.EAGER)
    //private Course course;

    @Column(name = "date")
    private Date date;

    @Column(name = "announcement")
    private String announcement;


}


