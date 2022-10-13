package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.dto.NewEnrollmentDto;
import lk.ac.kln.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("")
    public ResponseEntity<Optional<Enrollment>> saveEnrollment(NewEnrollmentDto enrollmentInfo) {
        Optional<Enrollment> savedEnrollment = enrollmentService.saveEnrollment(enrollmentInfo);

        if(savedEnrollment.isEmpty()) {
            return new ResponseEntity<>(savedEnrollment, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }
}
