package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.dto.NewEnrollmentDto;
import lk.ac.kln.lms.dto.UpdateEnrollmentDto;
import lk.ac.kln.lms.repo.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
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
        return enrollmentRepo.findById(enrollmentId);
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

    @Override
    public Boolean updateEnrollment(UpdateEnrollmentDto enrollmentInfo) {
        Optional<Enrollment> foundEnrollment = enrollmentRepo.findById(enrollmentInfo.getEnrollmentId());
        if(foundEnrollment.isEmpty()) {
            return false;
        }

        Optional<AppUser> foundStudentRepo;
        Optional<Course> foundCourseRepo;
        if(!Objects.isNull(enrollmentInfo.getStudentId())) {
            foundStudentRepo = studentService.getAppUserById(enrollmentInfo.getStudentId());
            if(foundStudentRepo.isEmpty()) {
                return false;
            }
        }

        if(!Objects.isNull(enrollmentInfo.getCourseId())) {
            foundCourseRepo = courseService.getCourseById(enrollmentInfo.getCourseId());

            if(foundCourseRepo.isEmpty()) {
                return false;
            }
        }

        if(!Objects.isNull(enrollmentInfo.getEnrollmentDate())) {
            foundEnrollment.get().setEnrollmentDate(enrollmentInfo.getEnrollmentDate());
        }

        if(!Objects.isNull(enrollmentInfo.getCancelled()) && Objects.isNull(enrollmentInfo.getCancellationReason())) {
            return false;
        } else {
            foundEnrollment.get().setCancelled(enrollmentInfo.getCancelled());
        }

        if(!Objects.isNull(enrollmentInfo.getCancellationReason())) {
            foundEnrollment.get().setCancellationReason(enrollmentInfo.getCancellationReason());
        }

        enrollmentRepo.save(foundEnrollment.get());
        return true;
    }

    @Override
    public Optional<Enrollment> removeEnrollment(Long enrollmentId) {
        Optional<Enrollment> foundEnrollment = this.getEnrollmentById(enrollmentId);
        if(foundEnrollment.isEmpty()) {
            return Optional.empty();
        }
        enrollmentRepo.delete(foundEnrollment.get());
        return foundEnrollment;
    }
}
