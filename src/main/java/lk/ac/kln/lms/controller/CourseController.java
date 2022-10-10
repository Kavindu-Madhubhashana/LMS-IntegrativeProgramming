package lk.ac.kln.lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @GetMapping("")
    public ResponseEntity<List<String>> getAllCourses() {
        List<String> courses = new ArrayList<>();
        courses.add("Database Management");
        courses.add("Data Structures & Algorithms");
        courses.add("Object Oriented Programming");
        return new ResponseEntity<>(courses, HttpStatus.ACCEPTED);
    }
}
