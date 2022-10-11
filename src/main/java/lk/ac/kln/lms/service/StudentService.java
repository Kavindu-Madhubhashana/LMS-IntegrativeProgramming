package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Student;
import lk.ac.kln.lms.dto.CreateStudentDto;

import java.util.Optional;

public interface StudentService {

    Iterable<Student> getAllStudents();

    Optional<Student> getUserByStudentId(final String studentId);

    Boolean saveStudent(final CreateStudentDto studentInfo);

}
