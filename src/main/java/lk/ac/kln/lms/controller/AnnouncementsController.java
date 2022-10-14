package lk.ac.kln.lms.controller;


import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.AnnouncementsDto;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announcements")
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping("/saveannouncement")
    public ResponseEntity<Announcements> saveAnnouncement(@RequestBody AnnouncementsDto announcementInfo) {
        return new ResponseEntity<>(this.announcementsService.saveAnnouncement(announcementInfo), HttpStatus.ACCEPTED);
    }


}
