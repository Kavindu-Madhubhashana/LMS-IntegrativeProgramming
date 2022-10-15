package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.AnnouncementsDto;
import lk.ac.kln.lms.repo.AnnouncementsRepo;
import lk.ac.kln.lms.repo.AppUserRepo;
import lk.ac.kln.lms.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnouncementsServiceImpl implements AnnouncementsService{

    @Autowired
    private final AnnouncementsRepo announcementsRepo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Announcements saveAnnouncement(AnnouncementsDto announcement) {

        Announcements newAnnouncement = new Announcements();
        newAnnouncement.setId(announcement.getId());
        newAnnouncement.setDate(announcement.getDate());
        newAnnouncement.setAnnouncement(announcement.getAnnouncement());

        AppUser lecturer = appUserRepo.findById(announcement.getLecturerId()).get();
        newAnnouncement.setLecturer(lecturer);

        Course course = courseRepo.findById(announcement.getId()).get();
        newAnnouncement.setCourse(course);

        return this.announcementsRepo.save(newAnnouncement);

    }

    @Override
    public Iterable<Announcements> getAnnouncementsByCourseCode(AnnouncementsDto courseCode) {
        Course course = new Course();
        return announcementsRepo.findByCourseCode(course);
    }



}
