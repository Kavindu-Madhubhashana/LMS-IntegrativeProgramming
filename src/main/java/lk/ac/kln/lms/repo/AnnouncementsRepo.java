package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementsRepo extends JpaRepository<Announcements,Long> {
    Optional<Announcements> findById(final String id);
    Iterable<Announcements> findByCourseCode(final Course course);
}
