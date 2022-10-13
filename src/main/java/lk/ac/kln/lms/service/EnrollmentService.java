package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.dto.NewEnrollmentDto;

import java.util.Optional;

public interface EnrollmentService {

    Iterable<Enrollment> getAllEnrollments();

    Optional<Enrollment> getEnrollmentById(final Long enrollmentId);

    Optional<Enrollment> saveEnrollment(final NewEnrollmentDto enrollmentInfo);

}
