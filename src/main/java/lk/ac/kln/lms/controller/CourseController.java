package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<Iterable<Course>> getAllCourses() {

        return new ResponseEntity<>(courseService.allCourses(), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public String saveCourse(@RequestBody CreateCourseDto courseInfo) {
        System.out.println(courseInfo);
        return "saved";
    }
}
