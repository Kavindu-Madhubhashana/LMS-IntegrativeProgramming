package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.AnnouncementsDto;
import lk.ac.kln.lms.dto.GetAnnouncementsDto;
import lk.ac.kln.lms.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/announcements")
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping("/save")
    public ResponseEntity<Optional<Announcements>> saveCourse(@RequestBody AnnouncementsDto announcement) {
        try {
            return new ResponseEntity<>(Optional.of(this.announcementsService.saveAnnouncement(announcement)), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/view")
    public ResponseEntity<Iterable<Announcements>>getAnnouncementsByCourseCode(@RequestBody GetAnnouncementsDto announcement) throws Exception {
        try {
            return new ResponseEntity<>(announcementsService.getAnnouncementsByCourseCode(announcement),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(announcementsService.getAnnouncementsByCourseCode(announcement),HttpStatus.BAD_REQUEST);
        }
    }


}
