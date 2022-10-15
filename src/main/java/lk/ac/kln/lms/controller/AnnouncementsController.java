package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.dto.AnnouncementsDto;
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
    /*@Autowired
    private CourseService courseService;

    @GetMapping("/save")
    public  ResponseEntity<Iterable<Course>>  save(){
        return new ResponseEntity<>(courseService.allCourses(), HttpStatus.ACCEPTED);
    }*/

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping("/save")
    public ResponseEntity<Announcements> saveCourse(@RequestBody AnnouncementsDto announcement) {
        return new ResponseEntity<>(this.announcementsService.saveAnnouncement(announcement), HttpStatus.ACCEPTED);
    }

    @PostMapping("/view")
    public ResponseEntity<Iterable<Announcements>>getAnnouncementsByCourseCode(@RequestBody AnnouncementsDto announcement){
        return new ResponseEntity<>(announcementsService.getAnnouncementsByCourseCode(announcement),HttpStatus.ACCEPTED);
    }



}
