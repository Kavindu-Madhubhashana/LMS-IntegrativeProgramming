package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.DeleteCourseDto;
import lk.ac.kln.lms.dto.GetCourseDto;
import lk.ac.kln.lms.dto.UpdateCourseDto;
import lk.ac.kln.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<Iterable<Course>> getAllCourses() {

        return new ResponseEntity<>(courseService.allCourses(), HttpStatus.ACCEPTED);
    }

    @PostMapping("code")
    public ResponseEntity<Optional<Course>> getCourseByCourseCode(@RequestBody GetCourseDto courseCode) {
        return new ResponseEntity<>(courseService.getCourseByCourseCode(courseCode), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<Optional<Course>> saveCourse(@RequestBody CreateCourseDto courseInfo) {

        Optional<Course> savedCourse = this.courseService.saveCourse(courseInfo);

        if(savedCourse.isPresent()) {
            return new ResponseEntity<>(this.courseService.saveCourse(courseInfo), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(this.courseService.saveCourse(courseInfo), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("")
    public ResponseEntity<Course> updateCourse(@RequestBody UpdateCourseDto courseDataInfo) {
        return new ResponseEntity<>(this.courseService.updateCourseById(courseDataInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> removeCourse(@RequestBody DeleteCourseDto courseId) {
        return new ResponseEntity<>(this.courseService.removeCourseById(courseId), HttpStatus.ACCEPTED);
    }

}
