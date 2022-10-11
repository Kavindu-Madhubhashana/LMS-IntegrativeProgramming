package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Student;
import lk.ac.kln.lms.dto.CreateStudentDto;
import lk.ac.kln.lms.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Iterable<Student> getAllStudents() {
        return null;
    }

    @Override
    public Optional<Student> getUserByStudentId(String studentId) {
        return Optional.empty();
    }

    @Override
    public Boolean saveStudent(CreateStudentDto studentInfo) {
        Optional<Student> foundUser = this.studentRepo.findByStudentId(studentInfo.getStudentId());

        if(foundUser.isPresent()) {
            return null;
        }

        Student student = new Student();
        student.setStudentId(studentInfo.getStudentId());
        student.setName(studentInfo.getName());
        student.setEmail(studentInfo.getEmail());
        student.setBirthDate(studentInfo.getBirthDate());
        student.setPassword(studentInfo.getPassword());
        student.setPhoneNumber(studentInfo.getPhoneNumber());

        this.studentRepo.save(student);

        return true;
    }
}
