package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.dto.NewEnrollmentDto;
import lk.ac.kln.lms.repo.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AppUserService studentService;

    @Override
    public Iterable<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(Long enrollmentId) {
        return Optional.empty();
    }

    @Override
    public Optional<Enrollment> saveEnrollment(NewEnrollmentDto enrollmentInfo) {
        Optional<Course> foundCourse =  courseService.getCourseById(enrollmentInfo.getCourseId());

        if(foundCourse.isEmpty()) {
            return Optional.empty();
        }

        Optional<AppUser> foundStudent = studentService.getAppUserById(enrollmentInfo.getStudentId());

        if(foundStudent.isEmpty()) {
            return Optional.empty();
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setEnrollmentDate(enrollmentInfo.getEnrollmentDate());
        enrollment.setStudent(foundStudent.get());
        enrollment.setCourse(foundCourse.get());
        enrollment.setCancelled(false);
        enrollment.setCancellationReason("");

        return Optional.of(enrollmentRepo.save(enrollment));
    }
}
