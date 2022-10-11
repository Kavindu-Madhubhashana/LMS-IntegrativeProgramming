package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.dto.CreateStudentDto;
import lk.ac.kln.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public ResponseEntity<Boolean> createUser(@RequestBody CreateStudentDto studentInfo) {
        return new ResponseEntity<>(this.studentService.saveStudent(studentInfo), HttpStatus.CREATED);
    }
}
