package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.dto.NewEnrollmentDto;
import lk.ac.kln.lms.dto.UpdateEnrollmentDto;
import lk.ac.kln.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Enrollment>> getAllEnrollments() {
        return new ResponseEntity<>(enrollmentService.getAllEnrollments(), HttpStatus.ACCEPTED);
    }

    @GetMapping("{enrollmentId}")
    public ResponseEntity<Optional<Enrollment>> getEnrollmentById(@PathVariable Long enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(enrollmentId);

        if(enrollment.isEmpty()) {
            return new ResponseEntity<>(enrollment, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enrollment, HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<Optional<Enrollment>> saveEnrollment(NewEnrollmentDto enrollmentInfo) {
        Optional<Enrollment> savedEnrollment = enrollmentService.saveEnrollment(enrollmentInfo);

        if(savedEnrollment.isEmpty()) {
            return new ResponseEntity<>(savedEnrollment, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Boolean> updateEnrollment(UpdateEnrollmentDto updateEnrollmentInfo) {
        return new ResponseEntity<>(enrollmentService.updateEnrollment(updateEnrollmentInfo), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{enrollmentId}")
    public ResponseEntity<Optional<Enrollment>> removeEnrollmentById(@PathVariable Long enrollmentId) {
        Optional<Enrollment> deletedEnrollment = enrollmentService.removeEnrollment(enrollmentId);

        if(deletedEnrollment.isEmpty()) {
            return new ResponseEntity<>(deletedEnrollment, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedEnrollment, HttpStatus.ACCEPTED);
    }
}
