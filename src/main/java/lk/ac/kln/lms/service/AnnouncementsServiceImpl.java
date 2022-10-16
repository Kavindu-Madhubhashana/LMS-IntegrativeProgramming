package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.AnnouncementsDto;
import lk.ac.kln.lms.dto.GetAnnouncementsDto;
import lk.ac.kln.lms.dto.GetCourseDto;
import lk.ac.kln.lms.enums.RoleEnum;
import lk.ac.kln.lms.repo.AnnouncementsRepo;
import lk.ac.kln.lms.repo.AppUserRepo;
import lk.ac.kln.lms.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnouncementsServiceImpl implements AnnouncementsService{

    @Autowired
    private final AnnouncementsRepo announcementsRepo;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CourseService courseService;

    @Override
    public Announcements saveAnnouncement(AnnouncementsDto announcement) throws Exception {

        Announcements newAnnouncement = new Announcements();
        newAnnouncement.setDate(announcement.getDate());
        newAnnouncement.setAnnouncement(announcement.getAnnouncement());

        Optional<AppUser> lecturer = appUserService.getAppUserById(announcement.getUserId());

        if(lecturer.isEmpty()) {
            throw new Exception("Lecturer not found");
        }

        newAnnouncement.setLecturer(lecturer.get());

        Optional<Course> course = courseService.getCourseByCourseCode(new GetCourseDto(announcement.getCourseCode()));

        if(course.isEmpty()) {
            throw new Exception("Course not found");
        }
        newAnnouncement.setCourse(course.get());

        return this.announcementsRepo.save(newAnnouncement);
        // id -> update -< new
        // id == null -> save

    }

    @Override
    public Iterable<Announcements> getAnnouncementsByCourseCode(GetAnnouncementsDto announcementsDto) throws Exception {
        Optional<Course> foundCourse = courseService.getCourseByCourseCode(new GetCourseDto(announcementsDto.getCourseCode()));
        if (foundCourse.isPresent()) {
            return announcementsRepo.findByCourse(foundCourse.get());
        }
        throw new Exception("Course not found");
    }

}
